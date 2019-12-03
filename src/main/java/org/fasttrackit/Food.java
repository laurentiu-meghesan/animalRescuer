package org.fasttrackit;

import java.time.LocalDate;

public class Food {

    private String name;
    private int price;
    private int quantity;
    private boolean availability;
    private int fatLevel;
    LocalDate expirationDate;

    public Food(String name, int price, LocalDate expirationDate) {
        this.name = name;
        this.price = price;
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getFatLevel() {
        return fatLevel;
    }

    public void setFatLevel(int fatLevel) {
        this.fatLevel = fatLevel;
    }
}
