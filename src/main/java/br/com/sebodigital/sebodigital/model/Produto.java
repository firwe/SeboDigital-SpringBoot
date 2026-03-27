package br.com.sebodigital.sebodigital.model;

import jakarta.persistence.*;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private String editora;
    private String ano;
    private String valor;
    private String conservacao;
    private String categoria;

    @Column(length = 1000)
    private String descricao;

}