public class Bat extends Mammal {
    public Bat(){
        this.energyLevel = 300;
    }
    
    public Bat fly(){
        System.out.println("Flying.");
        this.energyLevel -= 50;
        return this;
    }
    
    public Bat eatHumans(){
        System.out.println("Eating.");
        this.energyLevel +=25;
        return this;
    }

    public Dragon attackTown(){
        System.out.println("Attacking.");
        this.energyLevel -= 100;
        return this;
    }
}
