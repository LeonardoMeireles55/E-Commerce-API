package com.leonardo.ecommerce.domain.ecommerce;

import com.leonardo.ecommerce.enums.CategoryEnums;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity_in_stock")
    private Integer quantityInStock;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private CategoryEnums categoryEnums;

    @Column(name = "photo_link")
    private String photoLink;

    @Column(name = "stars")
    private int stars;

    @Column(name = "off_price")
    private double offPrice;

    public Product(String name, String description, Double price, Integer quantityInStock, CategoryEnums categoryEnums, String photoLink, Double offPrice, Integer stars ) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.categoryEnums = categoryEnums;
        this.photoLink = photoLink;
        this.offPrice = offPrice;
        this.stars = stars;
    }
    public Product(Long id, String name, String description, Double price, Integer quantityInStock, CategoryEnums categoryEnums, String photoLink, Double offPrice, Integer stars ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.categoryEnums = categoryEnums;
        this.photoLink = photoLink;
        this.offPrice = offPrice;
        this.stars = stars;
    }
}

