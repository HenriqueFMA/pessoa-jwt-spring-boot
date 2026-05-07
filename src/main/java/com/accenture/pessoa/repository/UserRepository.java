package com.accenture.pessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.accenture.pessoa.entity.User;

/**
 * Repositório JPA para a entidade User.
 * Fornece método de busca por login para autenticação.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Busca um usuário pelo login para autenticação no Spring Security.
     */
    UserDetails findByLogin(String login);
}
