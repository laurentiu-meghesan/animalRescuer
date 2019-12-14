package org.fasttrackit;

public class RecreationActivity {

    private String name;
    private int foodConsuption;
    private int minuteLasting;
    private int spiritGrow;

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

    public int getSpiritGrow() {
        return spiritGrow;
    }

    public void setSpiritGrow(int spiritGrow) {
        this.spiritGrow = spiritGrow;
    }
}
