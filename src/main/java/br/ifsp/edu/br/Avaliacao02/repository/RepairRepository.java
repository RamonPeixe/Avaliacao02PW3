package br.ifsp.edu.br.Avaliacao02.repository;

import br.ifsp.edu.br.Avaliacao02.model.RepairJob;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepairRepository extends JpaRepository<RepairJob, Long> {
    Page<RepairJob> findAllByActiveTrue(Pageable pageable);
    List<RepairJob> findAllByActiveTrue();
}