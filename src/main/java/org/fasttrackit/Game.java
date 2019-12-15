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

        requireFeeding(rescuer, selectedAnimal);
        requireActivity(rescuer, selectedAnimal);

    }

    private void initAnimal() {
        Animal dog = new Dog("Dog", 1, "male");
        dog.setEnergyLevel(ThreadLocalRandom.current().nextInt(4, 10));
        dog.setFatLevel(ThreadLocalRandom.current().nextInt(1, 6));
        dog.setSpiritLevel(ThreadLocalRandom.current().nextInt(3, 6));
        dog.setFavoriteFood("bone");
        dog.setFavoriteRecreation("pet");
        dog.setHealthLevel(ThreadLocalRandom.current().nextInt(7, 10));
        dog.setHungerLevel(ThreadLocalRandom.current().nextInt(3, 8));

        availableAnimals[0] = dog;

        Animal cat = new Cat("Cat", 1, "female");
        cat.setEnergyLevel(ThreadLocalRandom.current().nextInt(4, 10));
        cat.setFatLevel(ThreadLocalRandom.current().nextInt(1, 6));
        cat.setSpiritLevel(ThreadLocalRandom.current().nextInt(3, 6));
        cat.setFavoriteFood("meat");
        cat.setFavoriteRecreation("pet");
        cat.setHealthLevel(ThreadLocalRandom.current().nextInt(7, 10));
        cat.setHungerLevel(ThreadLocalRandom.current().nextInt(3, 8));

        availableAnimals[1] = cat;

        Animal koala = new Animal("Koala", 2, "female");
        koala.setEnergyLevel(ThreadLocalRandom.current().nextInt(4, 10));
        koala.setFatLevel(ThreadLocalRandom.current().nextInt(1, 6));
        koala.setSpiritLevel(ThreadLocalRandom.current().nextInt(3, 6));
        koala.setFavoriteFood("banana");
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
        System.out.println("Please enter the desired name for your " + selectedAnimal.getName() + ".");
        Scanner scanner = new Scanner(System.in);

        String getAnimalNameFromUser = scanner.nextLine();
        selectedAnimal.setName(getAnimalNameFromUser);
    }

    private void displayPlayerAndAnimal(Rescuer rescuer, Animal selectedAnimal) {
        System.out.println(rescuer.getName() + ", age " + rescuer.getAge() + " is trying to rescue " +
                selectedAnimal.getName() + ", who is " + selectedAnimal.getAge() + " years old." +
                " " + rescuer.getName() + " is having " + rescuer.getCash() + "$. " + selectedAnimal.getName() +
                "'s prefered food is " + selectedAnimal.getFavoriteFood() + " and favourite recreational activity is " +
                selectedAnimal.getFavoriteRecreation() + ".");
        System.out.println(selectedAnimal.getName() + "'s hunger level is " + selectedAnimal.getHungerLevel() +
                ", spirit level " + selectedAnimal.getSpiritLevel() + ", health level " + selectedAnimal.getHealthLevel() +
                ", energy level " + selectedAnimal.getEnergyLevel() + " and fat level is " + selectedAnimal.getFatLevel());

    }

    private void requireFeeding(Rescuer rescuer, Animal selectedAnimal) {
        System.out.println("Do you want to feed your animal?(type y for yes, n if no)");
        Scanner scanner = new Scanner(System.in);
        String c = scanner.nextLine();
        if (c.equals("y") | c.equals("Y")) {
            int i = 1;
            System.out.println("Available food:");
            for (Food food : availableFood) {
                System.out.println((i++) + ". " + food.getName());
            }
            Scanner scanner1 = new Scanner(System.in);
            int selectedFood = scanner1.nextInt() - 1;
            try {
                if (selectedFood < availableFood.size()) {
                    rescuer.feedAnimal(selectedAnimal, availableFood.get(selectedFood));
                    rescuer.setCash(rescuer.getCash() - availableFood.get(selectedFood).getPrice());
                    System.out.println("After you feed " + selectedAnimal.getName() + " with " +
                            availableFood.get(selectedFood).getName() + ", your new budget is " +
                            rescuer.getCash() + "$.");

                } else
                    System.out.println("You want to give " + selectedAnimal.getName() +
                            " a non existing or unavailable food.");
            } catch (Exception e) {
                System.out.println("You want to give " + selectedAnimal.getName() +
                        " a non existing or unavailable food.");
            }

        } else if (c.equals("n") | c.equals("N")) {
            System.out.println("Ok, thank you. " + selectedAnimal.getName() + "'s hunger level is " +
                    selectedAnimal.getHungerLevel() + ".");
        } else {
            System.out.println("Answer with yes or no please.");
            requireFeeding(rescuer, selectedAnimal);
        }
    }

    private void requireActivity(Rescuer rescuer, Animal selectedAnimal) {
        System.out.println("Do you want to make some activity with " + selectedAnimal.getName() +
                "?(type y for yes, n if no)");
        Scanner scanner = new Scanner(System.in);
        String c = scanner.nextLine();
        if (c.equals("y") | c.equals("Y")) {
            System.out.println("Available activities are:");
            for (int i = 0; i < availableActivities.length; i++) {
                if (availableActivities[i] != null)
                    System.out.println((i + 1) + ". " + availableActivities[i].getName());
            }
            Scanner scanner1 = new Scanner(System.in);
            int selectedActivity = scanner1.nextInt() - 1;
            try {
                if (selectedActivity < availableActivities.length){
                    rescuer.recreation(selectedAnimal,availableActivities[selectedActivity]);
                    if (availableActivities[selectedActivity].getName().equals(availableActivities[0].getName())){
                        //if selected activity is running, then the animal will be hungrier and health level will decrease
                        selectedAnimal.setHungerLevel(selectedAnimal.getHungerLevel()+2);
                        selectedAnimal.setHealthLevel(selectedAnimal.getHealthLevel()-1);
                    }else if (availableActivities[selectedActivity].getName().equals(availableActivities[2].getName())){
                        selectedAnimal.setHungerLevel(selectedAnimal.getHungerLevel()+2);
                        selectedAnimal.setHealthLevel(selectedAnimal.getHealthLevel()+1);
                    }
                }

            } catch (Exception e) {
                System.out.println("You want to do an activity with " + selectedAnimal.getName() +
                        " that does not exist.");
            }

        } else if (c.equals("n") | c.equals("N")) {
            System.out.println("Ok, thank you. " + selectedAnimal.getName() + "'s spirit level is " +
                    selectedAnimal.getSpiritLevel() + ".");
        } else {
            System.out.println("Answer with yes or no please.");
            requireActivity(rescuer, selectedAnimal);
        }
        System.out.println(selectedAnimal.toString());
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
        RecreationActivity act3 = new RecreationActivity("sleep");
        availableActivities[2] = act3;

    }
}

