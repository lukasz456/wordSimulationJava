import java.util.Random;

public class Wolf extends Animal {

    public Wolf(int x, int y, World w, int age) {
        super(x, y, w, 5, age, 9);
        world.draw(x, y, Utiles.WOLF);
    }
}
