package br.com.projeto.apigerenciamentodeestoque.repository;

import br.com.projeto.apigerenciamentodeestoque.model.User.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findUserRoleByRoleName(UserRole.Roles roleName);
}
