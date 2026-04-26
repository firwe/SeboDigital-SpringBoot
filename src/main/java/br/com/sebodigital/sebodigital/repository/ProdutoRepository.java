package br.com.sebodigital.sebodigital.repository;

import br.com.sebodigital.sebodigital.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}