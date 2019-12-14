package org.fasttrackit;

public class Dog extends Animal {

    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    public void happy() {
        System.out.println(getName() + " is wagging its tail! <3 ");
    }

    @Override
    public String toString() {
        return "Dog " + super.toString();
    }
}
