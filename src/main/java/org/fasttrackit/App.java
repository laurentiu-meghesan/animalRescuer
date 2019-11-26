package org.fasttrackit;

import java.time.LocalDate;

public class App
{
    public static void main( String[] args )
    {

        Adopter firstAdopter = new Adopter("Laurentiu", 1000, 32, "male" );
//        firstAdopter.name = "Laurentiu";
//        firstAdopter.cash = 1000;
//        firstAdopter.gender = "male";
//        firstAdopter.age = 32;
        firstAdopter.patienceLevel=8;


        Animal firstAnimal = new Animal("Dog", 1, "female");
//        firstAnimal.age = 1;
        firstAnimal.favoriteFood = "Bone";
        firstAnimal.favoriteRecreation = "Running";
        firstAnimal.healthLevel = 10;
        firstAnimal.hungerLevel = 10;
//        firstAnimal.name = "Dog";
        firstAnimal.spiritLevel = 10;
        firstAnimal.fatLevel=3;
//        firstAnimal.gender = "female";
        firstAnimal.energyLevel = 10;


        Food bone = new Food("Bone", 50,LocalDate.of(2020,12,10));
        bone.availability = true;
//        bone.name = "Bone";
//        bone.price = 50;
        bone.quantity = 10;
//        bone.expirationDate = LocalDate.of(2020,12,10);
        bone.fatLevel = 0;

        System.out.println("Data de expirare: " + bone.expirationDate);


        RecreationActivity running=new RecreationActivity("Running");
//        running.name = "Running";
        running.spiritLevelGrow = 3;
        running.foodConsuption=3;
        running.minuteLasting = 10;


        Veterinarian firstVet=new Veterinarian("Nenea Ilie", "General Medicine");
//        firstVet.name = "Nenea Ilie";
//        firstVet.specialization="General Medicine";
        firstVet.age = 62;
        firstVet.patience=7;
        firstVet.price=80;


        Adopter secAdopter = new Adopter("Alexandru", 1200, 31,"male");
//        secAdopter.name= "Alexandru";
//        secAdopter.cash = 1200;




    }
}
