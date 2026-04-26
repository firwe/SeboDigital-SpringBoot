package br.com.sebodigital.sebodigital.web.controller;

// ... seus imports ...
import br.com.sebodigital.sebodigital.repository.ProdutoRepository;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AcervoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/acervo")
    public String listarAcervo(Model model) {
        model.addAttribute("produtos", produtoRepository.findAll());
        return "categories/acervo";
    }

    // --- CÓDIGO NOVO PARA O DELETE ---
    @PostMapping("/deletar-produto/{id}")
    public String deletarProduto(@PathVariable Long id) {
        // O Hibernate vai no banco e dá um DELETE FROM produtos WHERE id = ?
        produtoRepository.deleteById(id);

        // Atualiza a página magicamente sem o livro que acabou de ser apagado
        return "redirect:/acervo";
    }
}