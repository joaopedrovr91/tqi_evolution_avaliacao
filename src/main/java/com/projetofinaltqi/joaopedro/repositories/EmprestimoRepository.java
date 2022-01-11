package com.projetofinaltqi.joaopedro.repositories;

import com.projetofinaltqi.joaopedro.models.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    public List<Emprestimo> findByCpf(String cpf);

}
