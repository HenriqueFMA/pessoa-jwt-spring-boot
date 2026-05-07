package com.accenture.pessoa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.pessoa.entity.Pessoa;
import com.accenture.pessoa.repository.PessoaRepository;

/**
 * Serviço de negócio para operações CRUD da entidade Pessoa.
 */
@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    /**
     * Retorna todas as pessoas cadastradas.
     */
    @Transactional(readOnly = true)
    public List<Pessoa> findAll() {
        return repository.findAll();
    }

    /**
     * Busca uma pessoa pelo ID.
     */
    @Transactional(readOnly = true)
    public Optional<Pessoa> getPessoaById(Long id) {
        return repository.findById(id);
    }

    /**
     * Cria e persiste uma nova Pessoa.
     */
    @Transactional
    public Pessoa save(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    /**
     * Atualiza os dados de uma Pessoa existente.
     * Retorna Optional vazio se o ID não for encontrado.
     */
    @Transactional
    public Optional<Pessoa> update(Long id, Pessoa pessoaDetails) {
        return repository.findById(id).map(pessoa -> {
            pessoa.setNome(pessoaDetails.getNome());
            return repository.save(pessoa);
        });
    }

    /**
     * Remove uma Pessoa pelo ID.
     */
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
