package br.ifsp.edu.br.Avaliacao02.usuario;

import jakarta.validation.constraints.NotBlank;

public record dadosAutenticacao(
        @NotBlank String login,
        @NotBlank String senha
) {
}