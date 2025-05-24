package br.com.projeto.apigerenciamentodeestoque.model.User;

import jakarta.persistence.*;
import lombok.Data;

import javax.management.relation.Role;

@Table(name = "roles")
@Entity
@Data
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long roleId;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name", nullable = false, unique = true)
    private Roles roleName;

    public enum Roles{
        ADMIN,
        STOCKER,
        COMMON;
    }
}
