import java.util.Random;

public class Utiles {
    public static final char EMPTY = '.';
    public static final char PLANT = 'P';
    public static final char ANIMAL = 'A';
    public static final char HUMAN = 'H';
    public static final char WOLF = 'W';
    public static final char SHEEP = 'S';
    public static final char FOX = 'F';
    public static final char TURTLE = 'T';
    public static final char ANTILOPE = 'A';
    public static final char GRASS = 'G';
    public static final char SOWTHISTLE = 'S';
    public static final char GUARANA = 'G';
    public static final char BELLADONA = 'B';
    public static final char SOSNOWSKY = 'S';
    public static final int SIZE = 20;

    public enum Outcome {
        ATTACKER_WINS(1),
        DEFENDER_WINS(-1),
        REFLECTION(2),
        ESCAPE(-2),
        GUARANA_BOOST(3),
        GENDERING(0),
        NEW_CHILD(20),
        NO_CHILD(-20),
        OTHER(-10);

        private final int value;

        Outcome(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private static final Random rand = new Random();

    public static int randomInt(int max, int min) {
        return rand.nextInt(max - min) + min;
    }

    public static void randomNeighbour(int... newPos) {
        int temp = randomInt(100, 1);
        if (temp < 25 && newPos[0] < SIZE - 1) {
            newPos[0]++;
        } else if (temp < 50 && newPos[0] > 1) {
            newPos[0]--;
        } else if (temp < 75 && newPos[1] < SIZE - 1) {
            newPos[1]++;
        } else if (temp < 100 && newPos[1] > 1) {
            newPos[1]--;
        }
    }

    public static void randomNeighbourAntilope(int... newPos) {
        int temp = randomInt(100, 1);
        if (temp < 25 && newPos[0] < SIZE - 2) {
            newPos[0] += 2;
        } else if (temp < 50 && newPos[0] > 2) {
            newPos[0] -= 2;
        } else if (temp < 75 && newPos[1] < SIZE - 2) {
            newPos[1] += 2;
        } else if (temp < 100 && newPos[1] > 2) {
            newPos[1] -= 2;
        }
    }

    public static int randomX(int width) {
        return rand.nextInt(width);
    }

    public static int randomY(int height) {
        return rand.nextInt(height);
    }
}