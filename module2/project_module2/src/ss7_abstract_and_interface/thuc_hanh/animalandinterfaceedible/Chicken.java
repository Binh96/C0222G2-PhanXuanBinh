package ss7_abstract_and_interface.thuc_hanh.animalandinterfaceedible;

public class Chicken extends Animal implements Edible {
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    public String howToEat(){
        return "could be fried";
    }
}
