package br.com.sebodigital.sebodigital.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnunciarController {

    @GetMapping("/anunciar")
    public String exibirFormulario() {
        return "categories/anunciar";
    }
}