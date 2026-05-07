package com.accenture.pessoa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.pessoa.entity.Pessoa;
import com.accenture.pessoa.service.PessoaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Controller REST para operações CRUD de Pessoa.
 * - GET    /pessoas         → lista todas (autenticado)
 * - GET    /pessoas/{id}    → busca por ID (autenticado)
 * - POST   /pessoas         → cria nova (somente ADMIN)
 * - PUT    /pessoas/{id}    → atualiza (autenticado)
 * - DELETE /pessoas/{id}    → remove (autenticado)
 */
@RestController
@RequestMapping("/pessoas")
@Tag(name = "Pessoas", description = "Operações CRUD para a entidade Pessoa")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping
    @Operation(summary = "Listar todas as pessoas", description = "Retorna uma lista com todas as pessoas cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public List<Pessoa> getAllPessoas() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar pessoa por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pessoa encontrada"),
            @ApiResponse(responseCode = "404", description = "Pessoa não encontrada")
    })
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable Long id) {
        Optional<Pessoa> p = service.getPessoaById(id);
        return p.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar nova pessoa", description = "Somente usuários com role ADMIN podem criar")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pessoa criada com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado - necessário role ADMIN")
    })
    public Pessoa createPessoa(@RequestBody Pessoa pessoa) {
        return service.save(pessoa);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar pessoa por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pessoa atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Pessoa não encontrada")
    })
    public ResponseEntity<Pessoa> updatePessoa(@PathVariable Long id, @RequestBody Pessoa pessoaDetails) {
        Optional<Pessoa> updatePessoa = service.update(id, pessoaDetails);
        return updatePessoa.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar pessoa por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Pessoa removida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Pessoa não encontrada")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
