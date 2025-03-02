import java.util.Random;

public class SowThistle extends Plant {

    public SowThistle(int x, int y, World w, int age) {
        super(x, y, w, age, 0);
        world.draw(x, y, Utiles.SOWTHISTLE);
    }

    @Override
    public void action() {
        Random random = new Random();
        int new_x = x;
        int new_y = y;
        int[] cords = {new_x, new_y};
        Utiles.randomNeighbour(cords);
        Organism field = world.getField(cords);
        if (field == null) {
            for (int i = 0; i < 3; i++) {
                int sow_probability = random.nextInt(100) + 1;
                if (sow_probability > 35) {
                    SowThistle newPlant = new SowThistle(new_x, new_y, world, 0);
                    world.addOrganism(newPlant);
                    break;
                }
            }
        }
    }

    @Override
    public void draw() {
        world.draw(x, y, Utiles.SOWTHISTLE);
    }
}
