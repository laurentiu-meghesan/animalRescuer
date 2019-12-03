package org.fasttrackit;

public class Veterinarian {

    private String name;
    private String specialization;
    private int age;
    private int patience;
    private int price;

    public Veterinarian(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPatience() {
        return patience;
    }

    public void setPatience(int patience) {
        this.patience = patience;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
