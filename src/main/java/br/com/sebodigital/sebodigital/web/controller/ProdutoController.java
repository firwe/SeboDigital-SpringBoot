package br.com.sebodigital.sebodigital.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProdutoController {

    @GetMapping("/produto")
    public String detalhesProduto() {
        return "produto";
    }
}
