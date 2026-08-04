package br.com.creche.api.repository;

import br.com.creche.api.entity.PagamentoPix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<PagamentoPix, Long> {
}
