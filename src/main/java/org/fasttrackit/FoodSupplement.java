package org.fasttrackit;

import java.time.LocalDate;

public class FoodSupplement extends Food{

    int mineralsLevel;
    int vitaminsLevel;

    public FoodSupplement(String name, int price, LocalDate expirationDate) {
        super(name, price, expirationDate);
    }
}
