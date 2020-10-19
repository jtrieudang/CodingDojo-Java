public class Wizard extends Human{
    public Wizard(){
        this.health = 50;
        this.intelligence = 8;
    }

    public Wizard heal(Human heal){
        heal.health += this.intelligence;
        return this;
    }
    
    public Wizard fireball(Human target) {
        target.health -= this.intelligence*3;
        return this;
    }
}