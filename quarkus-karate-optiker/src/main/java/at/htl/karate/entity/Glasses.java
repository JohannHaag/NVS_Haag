package at.htl.karate.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
public class Glasses extends PanacheEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long Id;

    private String name = "";
    private double price = 80.0;
    private String colour = "";
    private String brand = "";
    private String glass_high = "";
    @ManyToOne
    User user;

    public Glasses() {
    }

    public Glasses(String name, String colour, String brand, Double price, String glass_high, User user ) {
        this.name = name;
        this.colour = colour;
        this.brand = brand;
        this.price = price;
        this.glass_high = glass_high;
        this.user = user;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getGlass_high() {
        return glass_high;
    }

    public void setGlass_high(String glass_high) {
        this.glass_high = glass_high;
    }
}

