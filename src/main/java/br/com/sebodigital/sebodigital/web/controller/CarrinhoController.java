package br.com.sebodigital.sebodigital.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarrinhoController {

    @GetMapping("/carrinho")
    public String exibirCarrinho() {
        return "carrinho";
    }
}