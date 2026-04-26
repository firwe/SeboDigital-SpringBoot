package br.com.sebodigital.sebodigital.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "agendamentos")
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_agendamento;

    private LocalDate data_agendamento;
    private String status;
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_servico")
    private Servico servico;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;
}