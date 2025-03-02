public class Sheep extends Animal {
    public Sheep(int x, int y, World w, int age) {
        super(x, y, w, 4, age, 4);
        world.draw(x, y, Utiles.SHEEP);
    }
}
