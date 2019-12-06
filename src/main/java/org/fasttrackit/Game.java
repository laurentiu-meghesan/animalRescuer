package org.fasttrackit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    Rescuer rescuer;
    Animal animal;
    Veterinarian veterinarian;

    public Game(Rescuer rescuer, Animal animal, Veterinarian veterinarian) {
        this.rescuer = rescuer;
        this.animal = animal;
        this.veterinarian = veterinarian;
    }

    private List<Food> availableFood = new ArrayList<>();
    private RecreationActivity[] availableActivities = new RecreationActivity[5];

    public void start() {

        System.out.println("Starting game...");
        initFood();
        initActivities();
        printingFood();
        printingActivities();

    }

    private void initFood() {

        Food food1 = new Food("Meat", 100, LocalDate.of(2020, 03, 15));
        availableFood.add(food1);
        Food food2 = new Food("Bone", 50, LocalDate.of(2020, 12, 20));
        availableFood.add(food2);
        Food food3 = new Food("Banana", 30, LocalDate.of(2020, 06, 06));
        availableFood.add(food3);
        Food food4 = new FoodSupplement("Vitamins", 120, LocalDate.of(2022, 04, 30));
        availableFood.add(food4);
    }

    private void initActivities() {

        RecreationActivity act1 = new RecreationActivity("running");
        availableActivities[0] = act1;
        RecreationActivity act2 = new RecreationActivity("pet");
        availableActivities[1] = act2;
        RecreationActivity act3 = new RecreationActivity("sleeping");
        availableActivities[2] = act3;

    }

    public void printingFood() {
        int i=1;
        for (Food food : availableFood) {

            System.out.println("Available food : " + (i++) + ". " + food.getName());
        }
    }

    public void printingActivities() {

        for (int i = 0; i < availableActivities.length; i++) {
            if (availableActivities[i] != null)
                System.out.println("Available activities : " + (i + 1) + ". " + availableActivities[i].getName());
        }
    }
}

