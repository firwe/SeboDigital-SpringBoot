package br.com.sebodigital.sebodigital.web.controller;

import br.com.sebodigital.sebodigital.model.Produto;
import br.com.sebodigital.sebodigital.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProdutoController {

        @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/produto/{id}")
    public String verDetalhesProduto(@PathVariable Long id, Model model) {
        
        Produto produtoClicado = produtoRepository.findById(id).orElse(null);
        
        if (produtoClicado == null) {
            return "redirect:/acervo";
        }
        
        model.addAttribute("produto", produtoClicado);
        
        return "produto"; 
    }
}