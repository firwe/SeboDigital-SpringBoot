package br.com.sebodigital.sebodigital.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AcervoController {

    @GetMapping("/acervo")
    public String listarAcervo() {
        return "categories/acervo";
    }
}