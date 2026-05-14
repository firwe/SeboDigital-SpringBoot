package br.com.sebodigital.sebodigital.web.controller;

import br.com.sebodigital.sebodigital.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("produtos", produtoRepository.findAll());
        model.addAttribute("romances", produtoRepository.findByCategoria("Romance"));

        return "home";
    }
}