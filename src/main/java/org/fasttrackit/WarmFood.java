package org.fasttrackit;

import java.time.LocalDate;

public class WarmFood extends Food {

    int proteinLevel;
    int carbohydratesLevel;

    public WarmFood(String name, int price, LocalDate expirationDate) {
        super(name, price, expirationDate);
    }
}
