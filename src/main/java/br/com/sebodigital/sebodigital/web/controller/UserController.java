package br.com.sebodigital.sebodigital.web.controller;

import br.com.sebodigital.sebodigital.model.Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    // 1. MÉTODO GET: Abre a página de login quando você digita a URL ou clica no link
    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @PostMapping("/login")
    public String efetuarLogin(@RequestParam String email,
                               @RequestParam String password,
                               HttpSession session) {

        if ("teste@teste.com".equals(email) && "123".equals(password)) {
            Usuario user = new Usuario();
            user.setNome("João Silva");
            session.setAttribute("usuarioLogado", user);
            return "redirect:/";
        }

        return "redirect:/login?erro";
    }
}