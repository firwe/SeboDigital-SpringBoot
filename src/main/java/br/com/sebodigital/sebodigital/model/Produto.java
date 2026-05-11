package br.com.sebodigital.sebodigital.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_produto;

    private String titulo;
    private String autor;
    private Double preco;
    private String editora;
    private Integer anoPublicacao;
    private String conservacao;
    private String categoria;
    private String area;
    private boolean colecao = false;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "usuario_dono_id")
    private Usuario dono;

    @Column(columnDefinition = "TEXT")
    private String imagemBase64;

    @OneToMany(mappedBy = "produto")
    private List<Agendamento> agendamentos;

    public Long getId_produto() { return id_produto; }
    public void setId_produto(Long id_produto) { this.id_produto = id_produto; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    public String getEditora() { return editora; }
    public void setEditora(String editora) { this.editora = editora; }

    public Integer getAnoPublicacao() { return anoPublicacao; }
    public void setAnoPublicacao(Integer anoPublicacao) { this.anoPublicacao = anoPublicacao; }

    public String getConservacao() { return conservacao; }
    public void setConservacao(String conservacao) { this.conservacao = conservacao; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public List<Agendamento> getAgendamentos() { return agendamentos; }
    public void setAgendamentos(List<Agendamento> agendamentos) { this.agendamentos = agendamentos; }

    public Usuario getDono() { return dono; }
    public void setDono(Usuario dono) { this.dono = dono; }

    public String getImagemBase64() { return imagemBase64; }
    public void setImagemBase64(String imagemBase64) { this.imagemBase64 = imagemBase64; }

    public boolean isColecao() { return colecao; }
    public void setColecao(boolean colecao) { this.colecao = colecao; }
}