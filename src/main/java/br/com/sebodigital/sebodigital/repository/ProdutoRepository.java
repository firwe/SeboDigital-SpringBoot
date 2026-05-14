package br.com.sebodigital.sebodigital.repository;

import br.com.sebodigital.sebodigital.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByColecaoTrue();
    List<Produto> findByCategoria(String categoria);
    List<Produto> findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(String titulo, String autor);
    List<Produto> findByArea(String area);
    List<Produto> findByCategoriaAndPrecoBetween(String categoria, Double min, Double max);
    List<Produto> findByPrecoBetween(Double min, Double max);
}