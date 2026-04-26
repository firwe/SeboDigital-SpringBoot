package br.com.sebodigital.sebodigital.repository;

import br.com.sebodigital.sebodigital.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}