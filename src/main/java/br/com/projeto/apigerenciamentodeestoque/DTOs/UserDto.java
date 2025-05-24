package br.com.projeto.apigerenciamentodeestoque.DTOs;

public record UserDto (String username,
                       String password,
                       boolean active) {
}
