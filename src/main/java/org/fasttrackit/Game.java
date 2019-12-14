package org.fasttrackit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

    Rescuer rescuer;
    Animal animal;
    Veterinarian veterinarian;

/*    public Game(Rescuer rescuer, Animal animal, Veterinarian veterinarian) {
        this.rescuer = rescuer;
        this.animal = animal;
        this.veterinarian = veterinarian;
    }*/

    private Animal[] availableAnimals = new Animal[3];
    private List<Food> availableFood = new ArrayList<>();
    private RecreationActivity[] availableActivities = new RecreationActivity[5];

    public void start() {

        System.out.println("Starting game...");

        initAnimal();
        displayAnimals();
        Animal selectedAnimal = getSelectedAnimalFromUser();
        Rescuer rescuer = initUser();
        nameAnimal(selectedAnimal);
        displayPlayerAndAnimal(rescuer, selectedAnimal);

        initFood();
        initActivities();
        printingFood();
        printingActivities();

    }

    private void initAnimal() {
        Animal dog = new Dog("Dog", 1, "male");
        dog.setEnergyLevel(ThreadLocalRandom.current().nextInt(4, 10));
        dog.setFatLevel(ThreadLocalRandom.current().nextInt(1, 6));
        dog.setSpiritLevel(ThreadLocalRandom.current().nextInt(5, 9));
        dog.setFavoriteFood("Bone");
        dog.setFavoriteRecreation("pet");
        dog.setHealthLevel(ThreadLocalRandom.current().nextInt(7, 10));
        dog.setHungerLevel(ThreadLocalRandom.current().nextInt(3, 8));

        availableAnimals[0] = dog;

        Animal cat = new Cat("Cat", 1, "female");
        cat.setEnergyLevel(ThreadLocalRandom.current().nextInt(4, 10));
        cat.setFatLevel(ThreadLocalRandom.current().nextInt(1, 6));
        cat.setSpiritLevel(ThreadLocalRandom.current().nextInt(5, 9));
        cat.setFavoriteFood("Meat");
        cat.setFavoriteRecreation("pet");
        cat.setHealthLevel(ThreadLocalRandom.current().nextInt(7, 10));
        cat.setHungerLevel(ThreadLocalRandom.current().nextInt(3, 8));

        availableAnimals[1] = cat;

        Animal koala = new Animal("Koala", 2, "female");
        koala.setEnergyLevel(ThreadLocalRandom.current().nextInt(4, 10));
        koala.setFatLevel(ThreadLocalRandom.current().nextInt(1, 6));
        koala.setSpiritLevel(ThreadLocalRandom.current().nextInt(5, 9));
        koala.setFavoriteFood("Banana");
        koala.setFavoriteRecreation("sleep");
        koala.setHealthLevel(ThreadLocalRandom.current().nextInt(7, 10));
        koala.setHungerLevel(ThreadLocalRandom.current().nextInt(3, 8));

        availableAnimals[2] = koala;
    }

    private void displayAnimals() {
        System.out.println("Available animals are:");
        for (int i = 0; i < availableAnimals.length; i++)
            System.out.println((i + 1) + "." + availableAnimals[i].getName());
    }

    private Animal getSelectedAnimalFromUser() {
        System.out.println("Please select the desired animal:");
        try {
            Scanner scanner = new Scanner(System.in);
            int selectedAnimalNumber = scanner.nextInt();
            Animal selectedAnimal = availableAnimals[selectedAnimalNumber - 1];
            System.out.println("Selected animal is " + selectedAnimal.getName() + ".");
            return selectedAnimal;
        } catch (InputMismatchException e) {
            System.out.println("You have entered an invalid value.");
            return getSelectedAnimalFromUser();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You have entered an invalid value.");
            return getSelectedAnimalFromUser();
        }
    }

    private Rescuer initUser() {
        System.out.println("Enter you name, age and gender please: ");
        try {
            Scanner scanner = new Scanner(System.in);
            String userName = scanner.nextLine();
            Scanner scanner1 = new Scanner(System.in);
            int userAge = scanner1.nextInt();
            Scanner scanner2 = new Scanner(System.in);
            String userGender = scanner2.nextLine();

            Rescuer rescuer = new Rescuer(userName, ThreadLocalRandom.current().nextInt(1000, 2000),
                    userAge, userGender);
            return rescuer;
        } catch (Exception e) {
            System.out.println("You entered invalid data! Please try again.");
            return initUser();
        }
    }

    private void nameAnimal(Animal selectedAnimal) {
        System.out.println("Please enter the desired name for your " + selectedAnimal.getName());
        Scanner scanner = new Scanner(System.in);

        String getAnimalNameFromUser = scanner.nextLine();
        selectedAnimal.setName(getAnimalNameFromUser);
    }

    private void displayPlayerAndAnimal(Rescuer rescuer, Animal selectedAnimal) {
        System.out.println(rescuer.getName() + ", age " + rescuer.getAge() + " is trying to rescue " +
                selectedAnimal.getName() + ", who is " + selectedAnimal.getAge() + " years old." +
                " " + rescuer.getName() + " is having " + rescuer.getCash() + "$. "+selectedAnimal.getName()+
                "'s prefered food is "+selectedAnimal.getFavoriteFood()+" and favourite recreational activity is "+
                selectedAnimal.getFavoriteRecreation()+".");

    }

    private void initFood() {

        Food food1 = new Food("meat", 100, LocalDate.of(2020, 03, 15));
        availableFood.add(food1);
        Food food2 = new Food("bone", 50, LocalDate.of(2020, 12, 20));
        availableFood.add(food2);
        Food food3 = new Food("banana", 30, LocalDate.of(2020, 06, 06));
        availableFood.add(food3);
        Food food4 = new FoodSupplement("vitamins", 120, LocalDate.of(2022, 04, 30));
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
        int i = 1;
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

