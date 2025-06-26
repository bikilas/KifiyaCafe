package com.kifiya.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id; public Cafe getCafe() {
        return getCafe();
    }

    public void setCafe(Cafe cafe) {
        this.cafe = cafe;
    }

    private String name;
    private String description;
    private String image; // Typically stores a URL or file path
    private double price; // Use double or BigDecimal for currency
    private boolean isAvailable;
    private boolean featured; // Add featured field

    @ManyToOne
    @JoinColumn(name = "food_category_id") // Recommended: specify the foreign key column name
    private Category foodCategory; // Assuming you have a 'Category' entity

    @ElementCollection
    @CollectionTable(name = "food_images", joinColumns = @JoinColumn(name = "food_id"))
    @Column(name = "image_url") // Name of the column in the 'food_images' table
    private List<String> images; // Renamed to lowercase 'images' for consistency

    @ManyToOne
    @JoinColumn(name = "cafe_id") // Recommended: specify the foreign key column name
    // private Cafe cafe; // Assuming you have a 'Cafe' entity

    private boolean isVegetarian; // Corrected to camelCase and standard boolean prefix
    private boolean isSeasonal;

    private int popularity; // Add this field

    @ManyToMany
    @JoinTable(
            name = "food_ingredients",
            joinColumns = @JoinColumn(name = "food_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<IngredientsItem> ingredients;

    @Temporal(TemporalType.TIMESTAMP) // Specify how to map Date to database column
    private Date creationDate; // Corrected to camelCase
    private Cafe cafe;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public Category getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(Category foodCategory) {
        this.foodCategory = foodCategory;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

   

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public boolean isSeasonal() {
        return isSeasonal;
    }

    public void setSeasonal(boolean seasonal) {
        isSeasonal = seasonal;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public List<IngredientsItem> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientsItem> ingredients) {
        this.ingredients = ingredients;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}