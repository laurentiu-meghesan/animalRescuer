package org.fasttrackit;

import java.time.LocalDate;

public class WarmFood extends Food {

    private int proteinLevel;
    private int carbohydratesLevel;

    public WarmFood(String name, int price, LocalDate expirationDate) {
        super(name, price, expirationDate);
    }

    public int getProteinLevel() {
        return proteinLevel;
    }

    public void setProteinLevel(int proteinLevel) {
        this.proteinLevel = proteinLevel;
    }

    public int getCarbohydratesLevel() {
        return carbohydratesLevel;
    }

    public void setCarbohydratesLevel(int carbohydratesLevel) {
        this.carbohydratesLevel = carbohydratesLevel;
    }
}
