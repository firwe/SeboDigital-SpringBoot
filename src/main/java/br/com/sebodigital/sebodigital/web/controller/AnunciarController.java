package br.com.sebodigital.sebodigital.web.controller;

import br.com.sebodigital.sebodigital.model.Produto;
import br.com.sebodigital.sebodigital.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AnunciarController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/anunciar")
    public String exibirFormularioAnuncio() {
        return "categories/anunciar";
    }

    @PostMapping("/salvar-anuncio")
    public String salvarAnuncio(Produto produto) {

        produtoRepository.save(produto);

        return "redirect:/acervo";
    }

    @GetMapping("/editar-produto/{id}")
    public String editarProduto(@PathVariable Long id, Model model) {
        Produto livroParaEditar = produtoRepository.findById(id).orElse(null);
    
        model.addAttribute("produto", livroParaEditar);
    
        return "categories/anunciar";
    }
}