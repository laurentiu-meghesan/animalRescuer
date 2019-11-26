package org.fasttrackit;

public class Game {

    Rescuer rescuer;
    Animal animal;
    Veterinarian veterinarian;

    public Game(Rescuer rescuer, Animal animal, Veterinarian veterinarian) {
        this.rescuer = rescuer;
        this.animal = animal;
        this.veterinarian = veterinarian;
    }
}
