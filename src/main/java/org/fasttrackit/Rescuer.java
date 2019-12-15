package org.fasttrackit;

public class Rescuer {

    private String name;
    private int cash;
    private int age;
    private String gender;
    private int patienceLevel;

    public Rescuer(String name, int cash, int age, String gender) {
        this.name = name;
        this.cash = cash;
        this.age = age;
        this.gender = gender;
    }

    public void feedAnimal(Animal animal, Food food) {
        System.out.println(name + " just give some " + food.getName() + " to " + animal.getName() + ".");
        System.out.println(animal.getName() + " eats...");
        animal.setHungerLevel(animal.getHungerLevel() - 1);
        System.out.println("New hunger level is: " + animal.getHungerLevel());

        if (food.getName().equals(animal.getFavoriteFood())) {
            animal.setSpiritLevel(animal.getSpiritLevel() + 1);
            if (animal.getSpiritLevel() <= 10) {
                System.out.println("You give " + animal.getName() + " " + animal.getFavoriteFood() +
                        ", his favorite food and the new Spirit level is " + animal.getSpiritLevel());
            } else {
                animal.setSpiritLevel(10);
                System.out.println("You give " + animal.getName() + " " + animal.getFavoriteFood() +
                        " ,his favorite food, but his spirit level is already maximum of "
                        + animal.getSpiritLevel() + ".");
            }
        }
    }

    public void recreation(Animal animal, RecreationActivity recreationActivity) {
        System.out.println(name + " is " + recreationActivity.getName() + " with " + animal.getName() + "! <3 <3");
        if (recreationActivity.getName().equals(animal.getFavoriteRecreation())) {
            animal.setSpiritLevel(animal.getSpiritLevel() + 2);
            System.out.println(animal.getName() + "'s favourite activity is " + animal.getFavoriteRecreation() +
                    " and because you chose favourite activity, the new spirit level is increasing by 2.");
        } else
            animal.setSpiritLevel(animal.getSpiritLevel() + 1);

        if (animal.getSpiritLevel() <= 10) {
            System.out.println("The new spirit level is: " + animal.getSpiritLevel());
        } else {
            animal.setSpiritLevel(10);
            System.out.println(animal.getName() + "`s spirit level is already maximum of " + animal.getSpiritLevel());
        }
    }

    @Override
    public String toString() {
        return "Rescuer{" +
                "name='" + name + '\'' +
                ", cash=" + cash +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", patienceLevel=" + patienceLevel +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPatienceLevel() {
        return patienceLevel;
    }

    public void setPatienceLevel(int patienceLevel) {
        this.patienceLevel = patienceLevel;
    }
}