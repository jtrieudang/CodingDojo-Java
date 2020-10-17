public class Gorilla extends Mammal {
    public void throwSomething(){
        System.out.println("Throw banana.");
        this.energyLevel = energyLevel - 5;
    }

    public void eatBanana(){
        System.out.println("Eat banana.");
        this.energyLevel = energyLevel + 10;
    }

    public void climb(){
        System.out.println("Climb tree!");
        this.energyLevel = energyLevel - 10;
    }
}