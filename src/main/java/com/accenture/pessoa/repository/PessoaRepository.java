package com.accenture.pessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.pessoa.entity.Pessoa;

/**
 * Repositório JPA para a entidade Pessoa.
 * Herda operações CRUD padrão do JpaRepository.
 */
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
