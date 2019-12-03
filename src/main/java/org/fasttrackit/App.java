package org.fasttrackit;

import java.time.LocalDate;

public class App
{
    public static void main( String[] args )
    {
        Rescuer firstRescuer = new Rescuer("Laurentiu", 1000, 32, "male" );
        firstRescuer.patienceLevel=8;

        Animal firstAnimal = new Animal("Kevin", 1, "male");
        firstAnimal.favoriteFood = "Bone";
        firstAnimal.favoriteRecreation = "Running";
        firstAnimal.healthLevel = 10;
        firstAnimal.hungerLevel = 10;
        firstAnimal.spiritLevel = 10;
        firstAnimal.fatLevel=3;
        firstAnimal.energyLevel = 10;

        Food food = new Food("Bone", 50,LocalDate.of(2020,12,10));
        food.availability = true;
        food.quantity = 10;
//      bone.expirationDate = LocalDate.of(2020,12,10);
        food.fatLevel = 0;

        RecreationActivity running=new RecreationActivity("Running");
//      running.name = "Running";
        running.spiritLevelGrow = 3;
        running.foodConsuption=3;
        running.minuteLasting = 10;

        firstRescuer.feedAnimal(firstAnimal,food);
        firstRescuer.recreation(firstAnimal,running);

        Veterinarian firstVet=new Veterinarian("Nenea Ilie", "General Medicine");
        firstVet.age = 62;
        firstVet.patience=7;
        firstVet.price=80;


        Rescuer secRescuer = new Rescuer("Alexandru", 1200, 31,"male");





    }
}
