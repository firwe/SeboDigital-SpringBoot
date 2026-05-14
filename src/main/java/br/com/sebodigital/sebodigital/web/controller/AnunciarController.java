package br.com.sebodigital.sebodigital.web.controller;

import br.com.sebodigital.sebodigital.model.Produto;
import br.com.sebodigital.sebodigital.model.Usuario;
import br.com.sebodigital.sebodigital.repository.ProdutoRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

@Controller
public class AnunciarController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/anunciar")
    public String exibirFormularioAnuncio(HttpSession session) {
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        if (usuarioLogado == null) {
            return "redirect:/login?precisaLogar";
        }
        return "categories/anunciar";
    }

    @GetMapping("/editar-produto/{id}")
    public String editarProduto(@PathVariable Long id, Model model, HttpSession session) {
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        if (usuarioLogado == null) {
            return "redirect:/login?precisaLogar";
        }

        Produto livroParaEditar = produtoRepository.findById(id).orElse(null);
        model.addAttribute("produto", livroParaEditar);

        return "categories/anunciar";
    }
}