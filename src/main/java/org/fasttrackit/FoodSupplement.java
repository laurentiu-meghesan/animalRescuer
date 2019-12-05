package org.fasttrackit;

import java.time.LocalDate;

public class FoodSupplement extends Food {

    private int mineralsLevel;
    private int vitaminsLevel;

    public FoodSupplement(String name, int price, LocalDate expirationDate) {
        super(name, price, expirationDate);
    }

    public int getMineralsLevel() {
        return mineralsLevel;
    }

    public void setMineralsLevel(int mineralsLevel) {
        this.mineralsLevel = mineralsLevel;
    }

    public int getVitaminsLevel() {
        return vitaminsLevel;
    }

    public void setVitaminsLevel(int vitaminsLevel) {
        this.vitaminsLevel = vitaminsLevel;
    }
}
