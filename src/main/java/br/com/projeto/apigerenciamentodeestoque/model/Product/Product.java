package br.com.projeto.apigerenciamentodeestoque.model.Product;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String description;

    private BigDecimal priceCost;

    private BigDecimal priceSale;

    private int quantity;

    private Date dateCreated;
    private Date dateUpdated;
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryProduct categoryId;

}
