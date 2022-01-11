package com.projetofinaltqi.joaopedro.repositories;

import com.projetofinaltqi.joaopedro.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByEmail(String email);



    Cliente findByCpf(String cpf);

}
