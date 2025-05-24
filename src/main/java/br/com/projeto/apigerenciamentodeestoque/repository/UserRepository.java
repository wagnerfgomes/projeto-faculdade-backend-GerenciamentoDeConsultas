package br.com.projeto.apigerenciamentodeestoque.repository;

import br.com.projeto.apigerenciamentodeestoque.model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findUserByUsername(String username);
}
