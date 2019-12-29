package org.fasttrackit;

public class App {
    public static void main(String[] args) {

/*        Rescuer firstRescuer = new Rescuer("Laurentiu", 1000, 32, "male");
        firstRescuer.setPatienceLevel(8);

        Animal dog = new Dog("Kevin", 5, "male");
        dog.setFavoriteFood("Bone");
        dog.setFavoriteRecreation("Running");
        dog.setHealthLevel(10);
        dog.setHungerLevel(9);
        dog.setSpiritLevel(10);
        dog.setFatLevel(5);
        dog.setEnergyLevel(10);

        Animal koala = new Animal("Coco", 2, "female");
        koala.setFavoriteFood("banana");
        koala.setFavoriteRecreation("sleeping");
        koala.setHungerLevel(7);
        koala.setHealthLevel(10);
        koala.setSpiritLevel(8);
        koala.setFatLevel(2);
        koala.setEnergyLevel(6);

        Animal cat = new Cat("Milo", 1, "male");
        cat.setFavoriteFood("fish");
        cat.setFavoriteRecreation("play with the ball");
        cat.setHungerLevel(5);
        cat.setHealthLevel(9);
        cat.setSpiritLevel(7);
        cat.setFatLevel(4);
        cat.setEnergyLevel(8);


        Food food = new Food("Bone", 50, LocalDate.of(2020, 12, 10));
        food.setAvailability(true);
        food.setQuantity(10);
//      bone.expirationDate = LocalDate.of(2020,12,10);
        food.setFatLevel(0);

        RecreationActivity running = new RecreationActivity("Running");
//      running.name = "Running";
        running.setFoodConsuption(3);
        running.setMinuteLasting(10);

        System.out.println(koala.toString());
        System.out.println(cat.toString());
        firstRescuer.feedAnimal(dog, food);
        firstRescuer.recreation(dog, running);
        dog.happy();
        cat.happy();
        koala.happy();

        Veterinarian firstVet = new Veterinarian("Nenea Ilie", "General Medicine");
        firstVet.setAge(62);
        firstVet.setPatience(7);
        firstVet.setPrice(80);

        Rescuer secRescuer = new Rescuer("Alexandru", 1200, 31, "male");*/

        Game game = new Game();
        game.start();

    }
}
