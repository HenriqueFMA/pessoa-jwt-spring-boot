package com.accenture.pessoa.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidade que representa uma Pessoa no banco de dados.
 */
@Entity
@Table(name = "tb_pessoas")
@Schema(description = "Entidade Pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID gerado automaticamente", example = "1")
    private Long id;

    @Column(nullable = false)
    @Schema(description = "Nome da pessoa", example = "João Silva")
    private String nome;

    public Pessoa() {}

    public Pessoa(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
