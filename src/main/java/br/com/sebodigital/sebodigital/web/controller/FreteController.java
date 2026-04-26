package br.com.sebodigital.sebodigital.web.controller;

import br.com.sebodigital.sebodigital.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/frete")
public class FreteController {

    @Autowired
    private ViaCepService viaCepService;

    @GetMapping("/{cep}")
    public Map<String, Object> consultarFrete(@PathVariable String cep) {
        return viaCepService.calcularFreteViaCep(cep);
    }
}