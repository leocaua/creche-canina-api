package br.com.creche.api.repository;

import br.com.creche.api.entity.Rotina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RotinaRepository extends JpaRepository<Rotina,Long> {
}
