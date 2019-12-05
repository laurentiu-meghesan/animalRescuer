package org.fasttrackit;

public class Cat extends Animal {
    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void happy() {
        System.out.println(getName()+" purrs! <3 ");;
    }
}
