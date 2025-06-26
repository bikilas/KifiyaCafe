package com.kifiya.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;
    
    @Column(nullable = false)
    private Double price;
    
    @Column(nullable = false)
    private boolean isAvailable;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    
    @ManyToOne
    @JoinColumn(name = "cafe_id")
    private Cafe cafe;
    
    @ManyToMany
    @JoinTable(
        name = "menu_ingredients",
        joinColumns = @JoinColumn(name = "menu_id"),
        inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<IngredientsItem> ingredients;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    public Menu() {}
    
    public Menu(String name, Double price, boolean isAvailable) {
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
    }
}
