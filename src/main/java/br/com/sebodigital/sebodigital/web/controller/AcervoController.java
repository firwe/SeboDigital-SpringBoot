package br.com.sebodigital.sebodigital.web.controller;

import br.com.sebodigital.sebodigital.repository.ProdutoRepository;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AcervoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping("/deletar-produto/{id}")
    public String deletarProduto(@PathVariable Long id) {
        produtoRepository.deleteById(id);

        return "redirect:/acervo";
    }
}