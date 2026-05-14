package br.com.sebodigital.sebodigital.web.controller;

import br.com.sebodigital.sebodigital.model.Produto;
import br.com.sebodigital.sebodigital.repository.ProdutoRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarrinhoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/carrinho")
    public String exibirCarrinho(HttpSession session, Model model) {
        List<Produto> carrinho = (List<Produto>) session.getAttribute("carrinho");
        if (carrinho == null) {
            carrinho = new ArrayList<>();
        }

        double total = carrinho.stream().mapToDouble(Produto::getPreco).sum();

        model.addAttribute("itens", carrinho);
        model.addAttribute("total", total);
        return "carrinho";
    }

    @PostMapping("/carrinho/adicionar")
    public String adicionarAoCarrinho(@RequestParam Long id_produto, HttpSession session) {
        Produto produto = produtoRepository.findById(id_produto).orElse(null);

        if (produto != null) {
            List<Produto> carrinho = (List<Produto>) session.getAttribute("carrinho");
            if (carrinho == null) {
                carrinho = new ArrayList<>();
            }
            carrinho.add(produto);
            session.setAttribute("carrinho", carrinho);
        }
        return "redirect:/carrinho";
    }

    @PostMapping("/carrinho/remover")
    public String removerDoCarrinho(@RequestParam int index, HttpSession session) {
        List<Produto> carrinho = (List<Produto>) session.getAttribute("carrinho");
        if (carrinho != null && index >= 0 && index < carrinho.size()) {
            carrinho.remove(index);
            session.setAttribute("carrinho", carrinho);
        }
        return "redirect:/carrinho";
    }
}