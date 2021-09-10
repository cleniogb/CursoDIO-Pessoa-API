package com.github.cleniogb.pessoa.repositories;

import com.github.cleniogb.pessoa.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
