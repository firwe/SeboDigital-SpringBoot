package br.com.sebodigital.sebodigital.web.controller;

import br.com.sebodigital.sebodigital.model.Produto;
import br.com.sebodigital.sebodigital.model.Usuario;
import br.com.sebodigital.sebodigital.repository.ProdutoRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    // ... (listarAcervo, listarDesapega, listarColecoes e verDetalhes permanecem iguais)

    @GetMapping("/acervo")
    public String listarAcervo(
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) String busca,
            @RequestParam(required = false) Double min,
            @RequestParam(required = false) Double max,
            Model model) {

        double precoMin = (min != null) ? min : 0.0;
        double precoMax = (max != null) ? max : 9999.0;

        List<Produto> lista;

        if (busca != null && !busca.isEmpty()) {
            lista = produtoRepository.findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(busca, busca);
        } else if (categoria != null && !categoria.isEmpty()) {
            lista = produtoRepository.findByCategoriaAndPrecoBetween(categoria, precoMin, precoMax);
        } else {
            lista = produtoRepository.findByPrecoBetween(precoMin, precoMax);
        }

        model.addAttribute("produtos", lista);
        model.addAttribute("categoriaSelecionada", categoria);
        model.addAttribute("min", min);
        model.addAttribute("max", max);

        return "categories/acervo";
    }

    @GetMapping("/desapega")
    public String listarDesapega(
            @RequestParam(required = false) String area,
            @RequestParam(required = false) Double min,
            @RequestParam(required = false) Double max,
            Model model) {

        double pMin = (min != null) ? min : 0.0;
        double pMax = (max != null) ? max : 9999.0;

        List<Produto> lista;
        if (area != null && !area.isEmpty()) {
            lista = produtoRepository.findByArea(area).stream()
                    .filter(p -> p.getPreco() >= pMin && p.getPreco() <= pMax)
                    .toList();
        } else {
            lista = produtoRepository.findByCategoriaAndPrecoBetween("Desapega Uni", pMin, pMax);
        }

        model.addAttribute("produtos", lista);
        model.addAttribute("areaSelecionada", area);
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        return "categories/desapega";
    }

    @GetMapping("/colecoes")
    public String listarColecoes(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String autor,
            @RequestParam(required = false) Double min,
            @RequestParam(required = false) Double max,
            Model model) {

        double pMin = (min != null) ? min : 0.0;
        double pMax = (max != null) ? max : 99999.0;

        List<Produto> lista = produtoRepository.findAll().stream()
                .filter(p -> p.getCategoria() != null && (
                        p.getCategoria().toLowerCase().contains("cole") ||
                                p.getCategoria().toLowerCase().contains("box") ||
                                p.isColecao()
                ))
                .filter(p -> p.getPreco() >= pMin && p.getPreco() <= pMax)
                .filter(p -> {
                    boolean matchesTitulo = (titulo == null || titulo.isEmpty() || p.getTitulo().toLowerCase().contains(titulo.toLowerCase()));
                    boolean matchesAutor = (autor == null || autor.isEmpty() || p.getAutor().toLowerCase().contains(autor.toLowerCase()));
                    return matchesTitulo && matchesAutor;
                })
                .toList();

        model.addAttribute("produtos", lista);
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("tituloSalvo", titulo);
        model.addAttribute("autorSalvo", autor);

        return "categories/colecoes";
    }

    @GetMapping("/produto/{id}")
    public String verDetalhesProduto(@PathVariable Long id, Model model) {
        Produto produtoClicado = produtoRepository.findById(id).orElse(null);
        if (produtoClicado == null) {
            return "redirect:/acervo";
        }
        model.addAttribute("produto", produtoClicado);
        return "produto";
    }

    @PostMapping("/salvar-anuncio")
    public String salvarAnuncio(@ModelAttribute Produto produto, @RequestParam("file") MultipartFile file, HttpSession session, RedirectAttributes redirectAttributes) {
        try {
            Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");

            if (usuarioLogado == null) {
                return "redirect:/login";
            }

            produto.setDono(usuarioLogado);

            if (produto.getId_produto() == null && (file == null || file.isEmpty())) {
                redirectAttributes.addFlashAttribute("erro", "A foto real do produto é obrigatória!");
                return "redirect:/anunciar";
            }

            if (file != null && !file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String base64Image = Base64.getEncoder().encodeToString(bytes);
                produto.setImagemBase64(base64Image);
            } else if (produto.getId_produto() != null) {
                Produto produtoAntigo = produtoRepository.findById(produto.getId_produto()).orElse(null);
                if (produtoAntigo != null) {
                    produto.setImagemBase64(produtoAntigo.getImagemBase64());
                }
            }

            produtoRepository.save(produto);
            redirectAttributes.addFlashAttribute("sucesso", "Produto anunciado com sucesso!");
            return "redirect:/acervo";

        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("erro", "Erro ao processar a imagem.");
            return "redirect:/anunciar";
        }
    }
}