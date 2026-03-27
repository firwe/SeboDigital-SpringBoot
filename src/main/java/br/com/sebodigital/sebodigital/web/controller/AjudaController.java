package br.com.sebodigital.sebodigital.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AjudaController {
    @GetMapping("/ajuda")
    public String ajuda() {
        return "categories/ajuda";
    }
}
