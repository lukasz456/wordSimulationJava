import java.util.Random;

public class Grass extends Plant {

    public Grass(int x, int y, World w, int age) {
        super(x, y, w, age, 0);
        world.draw(x, y, Utiles.GRASS);
    }

    @Override
    public Grass newPlant(int x, int y) {
        return new Grass(x, y, world, 0);
    }

    @Override
    public void draw() {
        world.draw(x, y, Utiles.GRASS);
    }
}
