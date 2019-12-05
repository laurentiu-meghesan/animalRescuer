package org.fasttrackit;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Rescuer firstRescuer = new Rescuer("Laurentiu", 1000, 32, "male");
        firstRescuer.setPatienceLevel(8);

        Dog firstAnimal = new Dog("Kevin", 1, "male");
        firstAnimal.setFavoriteFood("Bone");
        firstAnimal.setFavoriteRecreation("Running");
        firstAnimal.setHealthLevel(10);
        firstAnimal.setHungerLevel(10);
        firstAnimal.setSpiritLevel(10);
        firstAnimal.setFatLevel(3);
        firstAnimal.setEnergyLevel(10);

        Food food = new Food("Bone", 50, LocalDate.of(2020, 12, 10));
        food.setAvailability(true);
        food.setQuantity(10);
//      bone.expirationDate = LocalDate.of(2020,12,10);
        food.setFatLevel(0);

        RecreationActivity running = new RecreationActivity("Running");
//      running.name = "Running";
        running.setFoodConsuption(3);
        running.setMinuteLasting(10);


        firstRescuer.feedAnimal(firstAnimal, food);
        firstRescuer.recreation(firstAnimal, running);
        firstAnimal.happy();

        Veterinarian firstVet = new Veterinarian("Nenea Ilie", "General Medicine");
        firstVet.setAge(62);
        firstVet.setPatience(7);
        firstVet.setPrice(80);

        Rescuer secRescuer = new Rescuer("Alexandru", 1200, 31, "male");


    }
}
