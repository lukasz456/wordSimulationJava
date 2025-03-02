import java.util.Random;

public class Main {
    public static void main(String[] args) {
        boolean isAlive = true;
        Random rand = new Random();
        World world = new World(Utiles.SIZE, Utiles.SIZE);
        Human firstHuman = new Human(2, 15, world, 0);
        Wolf firstWolf = new Wolf(10, 17, world, 0);
        Sheep firstSheep = new Sheep(12, 10, world, 0);
        Fox firstFox = new Fox(14, 11, world, 0);
        Turtle firstTurtle = new Turtle(15, 15, world, 0);
        Antilope firstAntilope = new Antilope(1, 12, world, 0);
        Grass firstGrass = new Grass(15, 17, world, 0);
        SowThistle firstSowThistle = new SowThistle(6, 3, world, 0);
        Guarana firstGuarana = new Guarana(4, 5, world, 0);
        Belladona firstBelladona = new Belladona(7, 7, world, 0);
        SosnowskysHogweed firstSosnowskysHogweed = new SosnowskysHogweed(10, 10, world, 0);
        world.drawWorld();
        int i = 0;
        while(i < 50) {
            isAlive = world.getIsHumanAlive();
            if (!isAlive) {
                world.gotoxy(50, 50);
                System.out.println("YOU LOST");
                break;
            }
            System.out.print("\033[H\033[2J"); // clear the console in Java
            world.drawWorld();
            world.makeTurn();
            i++;
        }
        if (isAlive) {
            world.gotoxy(70, 50);
            System.out.println("YOU WON. YOU SURVIVED!");
        }
    }
}
