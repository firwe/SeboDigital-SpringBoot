package br.com.sebodigital.sebodigital.repository;

import br.com.sebodigital.sebodigital.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
}