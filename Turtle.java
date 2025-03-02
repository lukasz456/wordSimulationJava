import java.util.Random;

public class Turtle extends Animal {

    public Turtle(int x, int y, World w, int age) {
        super(x, y, w, 1, age, 2);
        world.draw(x, y, Utiles.TURTLE);
    }

    @Override
    public void action() {
        clear_prev_position();
        int new_x = x;
        int new_y = y;
        int move_chance = new Random().nextInt(100) + 1;

        if (move_chance > 25) {
            Utiles.randomNeighbour(new_x, new_y);
            x = new_x;
            y = new_y;
        }

        world.draw(x, y, Utiles.TURTLE);
    }

    @Override
    public Utiles.Outcome collision(Organism attacker) {
        if (attacker instanceof Turtle) {
            System.out.println("Turtles breeded!");
            return super.collision(attacker);
        } else if (attacker.getStrength() <= 5) {
            return Utiles.Outcome.REFLECTION;
        } else {
            return Utiles.Outcome.ATTACKER_WINS;
        }
    }

    @Override
    public Turtle newAnimal(int x, int y) {
        return new Turtle(x, y, world, 0);
    }
}
