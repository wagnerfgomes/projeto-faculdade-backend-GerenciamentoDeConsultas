package br.com.projeto.apigerenciamentodeestoque.model.Product;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "product")
public class CategoryProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "category_id")
    private UUID id;

    private String name;

    private String description;

}
