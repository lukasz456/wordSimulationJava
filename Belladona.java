import java.util.Random;

public class Belladona extends Plant {

    public Belladona(int x, int y, World w, int age) {
        super(x, y, w, age, 99);
        world.draw(x, y, Utiles.BELLADONA);
    }

    @Override
    public Belladona newPlant(int x, int y) {
        return new Belladona(x, y, world, 0);
    }

    @Override
    public void draw() {
        world.draw(x, y, Utiles.BELLADONA);
    }
}
