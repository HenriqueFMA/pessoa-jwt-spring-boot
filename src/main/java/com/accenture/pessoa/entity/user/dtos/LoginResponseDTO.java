package com.accenture.pessoa.entity.user.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO de resposta após login bem-sucedido, contendo o token JWT.
 */
@Schema(description = "Resposta de login com token JWT")
public record LoginResponseDTO(
        @Schema(description = "Token JWT gerado", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
        String token
) {}
