package org.fasttrackit;

public class RecreationActivity {

    private String name;
    private int foodConsuption;
    private int minuteLasting;

    public RecreationActivity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getFoodConsuption() {
        return foodConsuption;
    }

    public void setFoodConsuption(int foodConsuption) {
        this.foodConsuption = foodConsuption;
    }

    public int getMinuteLasting() {
        return minuteLasting;
    }

    public void setMinuteLasting(int minuteLasting) {
        this.minuteLasting = minuteLasting;
    }
}
