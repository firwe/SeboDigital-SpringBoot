package br.com.sebodigital.sebodigital.web.controller;

import br.com.sebodigital.sebodigital.model.Usuario;
import br.com.sebodigital.sebodigital.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @PostMapping("/login")
    public String efetuarLogin(@RequestParam String email, @RequestParam String password, HttpSession session) {

        Usuario user = usuarioRepository.findByEmailAndSenha(email, password);

        if (user != null) {
            session.setAttribute("usuarioLogado", user);
            return "redirect:/";
        }

        return "redirect:/login?erro";
    }

    @GetMapping("/cadastro")
    public String exibirCadastro() {
        return "user/cadastro";
    }

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/cadastrar")
    public String cadastrarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
        return "redirect:/login";
    }
}