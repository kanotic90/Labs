import java.util.Random;

class Creature {
    
    private String name;
    private int size;
    private int move;
    private Random random;
    
    public Creature(String name, int size, int move) {
        this.name = name;
        this.size = size;
        this.move = move;
        this.random = new Random();
    }

    // NAME
    public String getName() {
        return name;
    }

    public void eat(String food) {
        System.out.println(name + " just ate" + food);
        size += 10;
    }

    public void move() {
        if (size < 5) {
            System.out.println(name + " is too small to move");
            return;
        String[] directions = {"north", "south", "east", "west"};
        String randomDirection = directions[random.nextInt(directions.length)];

        System.out.println(name + " moved " + randomDirection);
        System.out.println(name + " shrunk a bit!");
        size -= 5;
    }

    public void talk() {
        String[] phrases = {
            "Greetings!",
            "Hungry Ha!",
            "I am in need of some food!",
            "I want to go somewhere"
        };

        String chosenPhrase = phrases[random.nextInt(phrases.length)];
        System.out.println(name + " says: \"" + chosenPhrase + "\"");
    }
}

public class Main {
    public static void main(String[] args){
        Creature creature = new Creature("Sobble", 20 ,10);
        creature.talk();
        creature.move();
        creature.eat("berries
        creature.move();
        creature.talk();
    }
} 