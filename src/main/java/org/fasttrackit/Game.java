package org.fasttrackit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class Game {

/*    public Game(Rescuer rescuer, Animal animal, Veterinarian veterinarian) {
        this.rescuer = rescuer;
        this.animal = animal;
        this.veterinarian = veterinarian;
    }*/

    private Animal[] availableAnimals = new Animal[3];
    private List<Food> availableFood = new ArrayList<>();
    private RecreationActivity[] availableActivities = new RecreationActivity[5];
    private boolean maximumSpiritLevelIsNotReached = true;
    private boolean animalIsNotStarving = true;
    private boolean enoughMoney = true;

    void start() {

        System.out.println("Starting game...");

        initAnimal();
        displayAnimals();
        Animal selectedAnimal = getSelectedAnimalFromUser();
        Rescuer rescuer = initUser();
        nameAnimal(selectedAnimal);
        displayPlayerAndAnimal(rescuer, selectedAnimal);

        initFood();
        initActivities();

        System.out.println();
        System.out.println("How do you want to play the game?" + '\n' + "1. Play until maxim spirit level is reached," +
                " you don't have enough money or animal is starving." + '\n' + "2. Play an entered number of rounds." +
                '\n' + "3. Play only five rounds and try to win.");
        Scanner scanner = new Scanner(System.in);
        try {
            int playerChoose = scanner.nextInt();

            switch (playerChoose) {

//      we can play until maxim spirit level is reached, you don't have enough money or animal is starving
                case 1: {
                    while (maximumSpiritLevelIsNotReached && animalIsNotStarving && enoughMoney) {
                        System.out.println();
                        requireFeeding(rescuer, selectedAnimal);
                        requireActivity(rescuer, selectedAnimal);
                    }
                    break;
                }
//      or we can ask the user to input how many rounds he want to play
                case 2: {
                    System.out.println("How many rounds do you want to play?");
                    Scanner scanner1 = new Scanner(System.in);
                    int nrRounds = scanner1.nextInt();
                    for (int i = 1; i <= nrRounds; i++) {
                        System.out.println();
                        requireFeeding(rescuer, selectedAnimal);
                        requireActivity(rescuer, selectedAnimal);
                        if (!maximumSpiritLevelIsNotReached) {
                            System.out.println("You helped " + selectedAnimal.getName() + " to reach maximum spirit level and " +
                                    "he is very happy. Congratulations, " + rescuer.getName() + "! You won the game!");
                            break;
                        } else if (!animalIsNotStarving | !enoughMoney) {
                            System.out.println("Sorry, you lost the game!");
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    for (int i = 1; i <= 5; i++) {
                        System.out.println();
                        System.out.println("Round number " + i + ":");
                        if (i == 5) {
                            System.out.println("Final round!");
                        }
                        requireFeeding(rescuer, selectedAnimal);
                        requireActivity(rescuer, selectedAnimal);
                        if (!maximumSpiritLevelIsNotReached) {
                            System.out.println("You helped " + selectedAnimal.getName() + " to reach maximum spirit level and " +
                                    "he is very happy. Congratulations, " + rescuer.getName() + "! You won the game!");
                            break;
                        } else if (!animalIsNotStarving | !enoughMoney) {
                            System.out.println("Sorry, you lost the game!");
                            break;
                        }
                        if (i == 5) {
                            System.out.println("Gave over!");
                        }
                    }
                    break;

                }
                default: {
                    System.out.println("You did not enter a valid gameplay.");
                    System.out.println();
                }
            }
        } catch (Exception e) {
            System.out.println("You did not enter a valid gameplay.");
            System.out.println();
        }
    }

    private void initAnimal() {
        Animal dog = new Dog("Dog", 1, "male");
        dog.setEnergyLevel(ThreadLocalRandom.current().nextInt(4, 10));
        dog.setFatLevel(ThreadLocalRandom.current().nextInt(1, 6));
        dog.setSpiritLevel(ThreadLocalRandom.current().nextInt(3, 6));
        dog.setFavoriteFood("bone");
        dog.setFavoriteRecreation("pet");
        dog.setHealthLevel(ThreadLocalRandom.current().nextInt(5, 10));
        dog.setHungerLevel(ThreadLocalRandom.current().nextInt(3, 8));

        availableAnimals[0] = dog;

        Animal cat = new Cat("Cat", 1, "female");
        cat.setEnergyLevel(ThreadLocalRandom.current().nextInt(4, 10));
        cat.setFatLevel(ThreadLocalRandom.current().nextInt(1, 6));
        cat.setSpiritLevel(ThreadLocalRandom.current().nextInt(3, 6));
        cat.setFavoriteFood("meat");
        cat.setFavoriteRecreation("pet");
        cat.setHealthLevel(ThreadLocalRandom.current().nextInt(5, 10));
        cat.setHungerLevel(ThreadLocalRandom.current().nextInt(3, 8));

        availableAnimals[1] = cat;

        Animal koala = new Animal("Koala", 2, "female");
        koala.setEnergyLevel(ThreadLocalRandom.current().nextInt(4, 10));
        koala.setFatLevel(ThreadLocalRandom.current().nextInt(1, 6));
        koala.setSpiritLevel(ThreadLocalRandom.current().nextInt(3, 6));
        koala.setFavoriteFood("banana");
        koala.setFavoriteRecreation("sleep");
        koala.setHealthLevel(ThreadLocalRandom.current().nextInt(5, 10));
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
        } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
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

            return new Rescuer(userName, ThreadLocalRandom.current().nextInt(1000, 2000),
                    userAge, userGender);
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
            try {
                int selectedFood = scanner1.nextInt() - 1;
                if (selectedFood < availableFood.size()) {
                    rescuer.feedAnimal(selectedAnimal, availableFood.get(selectedFood));
                    rescuer.setCash(rescuer.getCash() - availableFood.get(selectedFood).getPrice());
                    if (rescuer.getCash() <= 0) {
                        System.out.println("You don't have enough money to continue. Game Over!");
                        enoughMoney = false;
                        System.exit(0);
                    } else if (selectedAnimal.getSpiritLevel() >= 10) {
                        System.out.println("You helped " + selectedAnimal.getName() + " to reach maximum spirit level and " +
                                "he is very happy. Congratulations, " + rescuer.getName() + "! You won the game!");
                        maximumSpiritLevelIsNotReached = false;
                        System.exit(0);
                    } else {
                        System.out.println("After you feed " + selectedAnimal.getName() + " with " +
                                availableFood.get(selectedFood).getName() + ", your new budget is " +
                                rescuer.getCash() + "$.");
                    }
                    if (availableFood.get(selectedFood).equals(availableFood.get(3))) {
                        selectedAnimal.setHealthLevel(selectedAnimal.getHealthLevel() + 1);
                        if (selectedAnimal.getHealthLevel() >= 10) {
                            selectedAnimal.setHealthLevel(10);
                            System.out.println(selectedAnimal.getName() + " is very healthy! Congratulations!");
                        }
                    }
                    if (selectedAnimal.getHealthLevel() >= 10) {
                        selectedAnimal.setSpiritLevel(selectedAnimal.getSpiritLevel() + 1);
                    }
                } else {
                    System.out.println("You want to give " + selectedAnimal.getName() +
                            " a non existing or unavailable food.");
                    requireFeeding(rescuer, selectedAnimal);
                }
            } catch (InputMismatchException | IndexOutOfBoundsException e) {
                System.out.println("You want to give " + selectedAnimal.getName() +
                        " a non existing or unavailable food.");
                requireFeeding(rescuer, selectedAnimal);
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
            try {
                int selectedActivity = scanner1.nextInt() - 1;
                if (selectedActivity < availableActivities.length) {
                    rescuer.recreation(selectedAnimal, availableActivities[selectedActivity]);
                    if (availableActivities[selectedActivity].getName().equals(availableActivities[0].getName())) {
                        //if selected activity is running, then the animal will be hungrier and health level will decrease
                        selectedAnimal.setHungerLevel(selectedAnimal.getHungerLevel() + 2);
                        selectedAnimal.setHealthLevel(selectedAnimal.getHealthLevel() - 1);
                    } else if (availableActivities[selectedActivity].getName().equals(availableActivities[2].getName())) {
                        selectedAnimal.setHungerLevel(selectedAnimal.getHungerLevel() + 2);
                        selectedAnimal.setHealthLevel(selectedAnimal.getHealthLevel() + 1);
                    } else if (availableActivities[selectedActivity].getName().equals(availableActivities[1].getName())) {
                        selectedAnimal.setHungerLevel(selectedAnimal.getHungerLevel() + 1);
                    }
                    if (selectedAnimal.getSpiritLevel() >= 10) {
                        System.out.println("You helped " + selectedAnimal.getName() + " to reach maximum spirit level and " +
                                "he is very happy. Congratulations, " + rescuer.getName() + "! You won the game!");
                        maximumSpiritLevelIsNotReached = false;
                        System.exit(0);
                    } else if (selectedAnimal.getHungerLevel() >= 10) {
                        System.out.println("You forgot to feed " + selectedAnimal.getName() + ". You failed to rescue the " +
                                "animal. Game over!");
                        animalIsNotStarving = false;
                        System.out.println(selectedAnimal.toString());
                        System.exit(0);
                    }
                    System.out.println(selectedAnimal.toString());
                } else if (selectedActivity > availableActivities.length) {
                    System.out.println("You want to do an activity with " + selectedAnimal.getName() +
                            " that does not exist.");
                    requireActivity(rescuer, selectedAnimal);
                }
            } catch (InputMismatchException | IndexOutOfBoundsException e) {
                System.out.println("You want to do an activity with " + selectedAnimal.getName() +
                        " that does not exist.");
                requireActivity(rescuer, selectedAnimal);
            }

        } else if (c.equals("n") | c.equals("N")) {
            System.out.println("Ok, thank you. " + selectedAnimal.getName() + "'s spirit level is " +
                    selectedAnimal.getSpiritLevel() + ".");
        } else {
            System.out.println("Answer with yes or no please.");
            requireActivity(rescuer, selectedAnimal);
        }
    }

    private void initFood() {

        Food food1 = new Food("meat", 300, LocalDate.of(2020, 3, 15));
        availableFood.add(food1);
        Food food2 = new Food("bone", 250, LocalDate.of(2020, 12, 20));
        availableFood.add(food2);
        Food food3 = new Food("banana", 150, LocalDate.of(2020, 6, 6));
        availableFood.add(food3);
        Food food4 = new FoodSupplement("vitamins", 200, LocalDate.of(2022, 4, 30));
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

