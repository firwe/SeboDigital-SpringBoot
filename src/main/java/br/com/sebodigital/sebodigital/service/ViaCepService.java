package br.com.sebodigital.sebodigital.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class ViaCepService {

    public Map<String, Object> calcularFreteViaCep(String cep) {
        cep = cep.replaceAll("\\D", "");
        
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        RestTemplate restTemplate = new RestTemplate();

        try {
            Map<String, Object> endereco = restTemplate.getForObject(url, Map.class);
            
            if (endereco == null || endereco.containsKey("erro")) {
                return null; 
            }
            
            String uf = (String) endereco.get("uf");
            double valorFrete = "SP".equalsIgnoreCase(uf) ? 12.50 : 28.90;
            String prazo = "SP".equalsIgnoreCase(uf) ? "3 a 5 dias úteis" : "7 a 12 dias úteis";
            
            endereco.put("valorFrete", valorFrete);
            endereco.put("prazo", prazo);
            
            return endereco;
            
        } catch (Exception e) {
            return null;
        }
    }
}