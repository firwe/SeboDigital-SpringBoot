package br.com.sebodigital.sebodigital.web.controller;

import br.com.sebodigital.sebodigital.repository.ProdutoRepository; // Importação necessária
import org.springframework.beans.factory.annotation.Autowired; // Importação necessária
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ColecoesController {

    @Autowired
    private ProdutoRepository produtoRepository;
}