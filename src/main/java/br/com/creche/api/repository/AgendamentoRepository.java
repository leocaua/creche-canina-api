package br.com.creche.api.repository;

import br.com.creche.api.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    long countByDataReserva(LocalDate dataReserva);
    boolean existsByPetIdAndDataReserva(Long petId, LocalDate dataReserva);

}
