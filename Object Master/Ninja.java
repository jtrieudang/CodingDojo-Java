public class Ninja extends Human {
    public int stealth;
    public Ninja() {
        this.stealth = 10;
    }
    
    public Ninja steal(Human target){
        target.health -= this.stealth;
        this.health += this.stealth;
        return this;
    }

    public Ninja runAway(){
        this.health -=10;
        return this;
    }
}