package com.accenture.pessoa.entity.user.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

/**
 * DTO para receber as credenciais de login.
 */
@Schema(description = "Dados de autenticação")
public record AuthenticationDTO(
        @NotBlank(message = "Login é obrigatório")
        @Schema(description = "Login do usuário", example = "admin@email.com")
        String login,

        @NotBlank(message = "Senha é obrigatória")
        @Schema(description = "Senha do usuário", example = "senha123")
        String password
) {}
