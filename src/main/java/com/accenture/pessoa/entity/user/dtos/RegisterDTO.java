package com.accenture.pessoa.entity.user.dtos;

import com.accenture.pessoa.entity.enums.UserRoles;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO para registro de novos usuários.
 */
@Schema(description = "Dados para registro de novo usuário")
public record RegisterDTO(
        @NotBlank(message = "Login é obrigatório")
        @Schema(description = "Login do usuário", example = "admin@email.com")
        String login,

        @NotBlank(message = "Senha é obrigatória")
        @Schema(description = "Senha do usuário", example = "senha123")
        String password,

        @NotNull(message = "Role é obrigatória")
        @Schema(description = "Role do usuário: ADMIN ou USER", example = "USER")
        UserRoles role
) {}
