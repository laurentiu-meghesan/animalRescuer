package org.fasttrackit;

public class App 
{
    public static void main( String[] args )
    {

        Game firstGame = new Game();
        firstGame.name = "Laurentiu";
        firstGame.animal = "Dog";
        firstGame.veterinarian = "Nenea Ilie";

        Adoptator firstAdoptator = new Adoptator();
        firstAdoptator.name = "Laurentiu";
        firstAdoptator.cash = 1000;
        firstAdoptator.gender = "male";
        firstAdoptator.age = 32;
        firstAdoptator.patience=8;



        Animal firstAnimal = new Animal();
        firstAnimal.age = 1;
        firstAnimal.favoriteFood = "Bone";
        firstAnimal.favoriteRecreation = "Running";
        firstAnimal.health = 10;
        firstAnimal.hunger = 10;
        firstAnimal.name = "Dog";
        firstAnimal.spiritLevel = 10;
        firstAnimal.fatLevel=3;
        firstAnimal.gener = "female";
        firstAnimal.energy = 10;


        Food bone = new Food();
        bone.availability = true;
        bone.name = "Bone";
        bone.price = 50;
        bone.quantity = 10;
        bone.expDate = null;
        bone.fatLevel = 0;


        RecreationActivity running=new RecreationActivity();
        running.name = "Fugit";
        running.spiritLevelGrow = 3;
        running.foodConsuption=3;
        running.minuteLasting = 10;


        Veterinarian firstVet=new Veterinarian();
        firstVet.name = "Nenea Ilie";
        firstVet.specialization="Medicina generala";
        firstVet.age = 62;
        firstVet.patience=7;
        firstVet.price=80;


        Adoptator secAdoptator = new Adoptator();
        secAdoptator.name= "Alexandru";
        secAdoptator.cash = 1200;




    }
}
