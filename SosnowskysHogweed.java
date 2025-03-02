import java.util.*;
public class SosnowskysHogweed extends Plant {
    public SosnowskysHogweed(int x, int y, World w, int age) {
        super(x, y, w, age, 10);
        world.draw(x, y, Utiles.SOSNOWSKY);
    }

    @Override
    public void action() {
        int[] cords = {x, y+1};
        Organism upNeighbour = world.getField(cords);
        cords[0] = x-1;
        cords[1] = y;
        Organism leftNeighbour = world.getField(cords);
        cords[0] = x+1;
        cords[1] = y;
        Organism rightNeighbour = world.getField(cords);
        cords[0] = x;
        cords[1] = y-1;
        Organism downNeighbour = world.getField(cords);
        if (upNeighbour != null) {
            world.killOrganism(upNeighbour);
        } else if (leftNeighbour != null) {
            world.killOrganism(leftNeighbour);
        } else if (rightNeighbour != null) {
            world.killOrganism(rightNeighbour);
        } else if (downNeighbour != null) {
            world.killOrganism(downNeighbour);
        }
    }

    public void draw() {
        world.draw(x, y, Utiles.SOSNOWSKY);
    }
}
