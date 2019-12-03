package org.fasttrackit;

public class Rescuer {

    String name;
    int cash;
    int age;
    String gender;
    int patienceLevel;

    public Rescuer(String name, int cash, int age, String gender) {
        this.name = name;
        this.cash = cash;
        this.age = age;
        this.gender = gender;
    }

    public void feedAnimal(Animal animal,Food food){
        System.out.println(name+" just give some "+food.name+" food to "+animal.name +".");
        System.out.println(animal.name + " eats...");
        animal.hungerLevel=animal.hungerLevel-1;
        System.out.println("New hunger level is: " + animal.hungerLevel);

        if (food.name==animal.favoriteFood){
            animal.spiritLevel++;
            if (animal.spiritLevel<=10) {
                System.out.println("You give " + animal.name + " " + animal.favoriteFood +
                        " ,his favorite food and the new Spirit level is " + animal.spiritLevel);
            }else{
                animal.spiritLevel=10;
                System.out.println("You give " + animal.name + " " + animal.favoriteFood +
                        " ,his favorite food, but his spirit level is allready maximum of "
                        + animal.spiritLevel+".");
            }
        }

    }

    public void recreation(Animal animal,RecreationActivity recreationActivity){
        System.out.println(name+" is "+ recreationActivity.name+ " with "+animal.name + "! <3 <3");
        if (recreationActivity.name==animal.favoriteRecreation){
            animal.spiritLevel=animal.spiritLevel+2;
        }else
            animal.spiritLevel++;

        if (animal.spiritLevel<=10){
            System.out.println("The new spirit level is: "+ animal.spiritLevel);
        }
        else {
            animal.spiritLevel=10;
            System.out.println(animal.name+"`s spirit level is allready maximum of "+animal.spiritLevel);
        }
    }
}