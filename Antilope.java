public class Antilope extends Animal {
    public Antilope(int x, int y, World w, int age) {
        super(x, y, w, 4, age, 4);
        world.draw(x, y, Utiles.ANTILOPE);
    }

    @Override
    public void action() {
        clear_prev_position();
        int new_x = x;
        int new_y = y;

        Utiles.randomNeighbourAntilope(new_x, new_y);

        x = new_x;
        y = new_y;
        world.draw(x, y, Utiles.ANTILOPE);
    }

    @Override
    public Utiles.Outcome collision(Organism attacker) {
        if (attacker instanceof Antilope) {
            world.gotoxy(50, 7);
            System.out.println("Antilopes breeded!");
            return super.collision(attacker);
        }

        int escape_chance = Utiles.randomInt(100, 1);
        if (attacker.getStrength() >= strength && escape_chance <= 50) {
            return Utiles.Outcome.ATTACKER_WINS;
        } else if (attacker.getStrength() >= strength && escape_chance > 50) {
            return Utiles.Outcome.ESCAPE;
        } else if (attacker.getStrength() < strength) {
            return Utiles.Outcome.DEFENDER_WINS;
        }

        // Return a default value to satisfy the compiler
        return Utiles.Outcome.DEFENDER_WINS;
    }

    public Antilope newAnimal(int x, int y) {
        return new Antilope(x, y, world, 0);
    }
}
