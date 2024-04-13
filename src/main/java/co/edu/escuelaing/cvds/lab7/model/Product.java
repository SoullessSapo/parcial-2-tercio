package co.edu.escuelaing.cvds.lab7.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "PRODUCT")

public class Product {
    @Id
    @Column(name = "ID")
    private int id;

    @Getter
    @Column(name = "NAME")
    private String name;

    @Getter
    @Column(name= "Description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "Category")
    private Category category;

    @Column(name = "Rating")
    private int rating;

    @Getter
    @Column(name = "Price")
    private int price;

    @Getter
    @Column(name = "Quantity")
    private int quantity;

    public Product (int id, String name, String description, String category, int rating, int price, int quantity){
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = Category.valueOf(category);
        this.price = price;
        this.quantity = quantity;
        setRating(rating);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public enum Category {
        Clothes, Food, Technology , Drugstore
    }

    public void setRating(int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating debe estar entre 1 y 5");
        }
        this.rating = rating;
    }
}
