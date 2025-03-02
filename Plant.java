import java.util.Random;

public class Plant extends Organism {

    public Plant(int x, int y, World w, int age, int strength) {
        super(x, y, w, 0, age, strength);
    }

    @Override
    public void action() {
        int new_x = x;
        int new_y = y;

        Utiles.randomNeighbour(new_x, new_y);

        Organism field = world.getField(new_x, new_y);

        if (field == null) {
            int sow_probability = new Random().nextInt(100) + 1;

            if (sow_probability > 35) {
                Plant newPlant = this.newPlant(new_x, new_y);
            }
        }
    }

    @Override
    public void draw() {
        world.draw(y, x, Utiles.PLANT);
    }


    public Plant newPlant(int x, int y) {
        Plant n = new Plant(x, y, world, 0, strength);
        return n;
    }
}
