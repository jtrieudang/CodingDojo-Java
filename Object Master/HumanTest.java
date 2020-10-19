public class HumanTest{
    public static void main (String[] args){
        Human human = new Human();
        Human human2 = new Human();
        human.attack(human2);
        human2.displayHealth();
    }
}