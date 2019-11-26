package org.fasttrackit;

import java.time.LocalDate;

public class Food {

    String name;
    int price;
    int quantity;
    boolean availability;
    int fatLevel;
    LocalDate expirationDate;

    public Food(String name, int price, LocalDate expirationDate) {
        this.name = name;
        this.price = price;
        this.expirationDate = expirationDate;
    }
}
