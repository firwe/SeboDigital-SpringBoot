package br.com.sebodigital.sebodigital.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    private String nome;
    private String email;
    private String senha;
    private String telefone;

    private boolean admin = false;

    @OneToMany(mappedBy = "dono")
    private List<Produto> meusProdutos;

    @OneToMany(mappedBy = "usuario")
    private List<Agendamento> agendamentos;

    public Long getId_usuario() { return id_usuario; }
    public void setId_usuario(Long id_usuario) { this.id_usuario = id_usuario; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public boolean isAdmin() { return admin; }
    public void setAdmin(boolean admin) { this.admin = admin; }

    public List<Produto> getMeusProdutos() { return meusProdutos; }
    public void setMeusProdutos(List<Produto> meusProdutos) { this.meusProdutos = meusProdutos; }

    public List<Agendamento> getAgendamentos() { return agendamentos; }
    public void setAgendamentos(List<Agendamento> agendamentos) { this.agendamentos = agendamentos; }
}