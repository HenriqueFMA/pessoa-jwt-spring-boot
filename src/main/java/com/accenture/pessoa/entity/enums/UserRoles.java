package com.accenture.pessoa.entity.enums;

/**
 * Roles disponíveis para os usuários da aplicação.
 * ADMIN: acesso total (incluindo criação de Pessoas)
 * USER: acesso de leitura e atualização
 */
public enum UserRoles {
    ADMIN("admin"),
    USER("user");

    private final String role;

    UserRoles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
