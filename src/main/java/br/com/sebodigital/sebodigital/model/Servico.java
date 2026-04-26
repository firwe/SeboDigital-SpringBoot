package br.com.sebodigital.sebodigital.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "servicos")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_servico;

    private String nome;
    private double preco;

    @OneToMany(mappedBy = "servico")
    private List<Agendamento> agendamentos;
}
