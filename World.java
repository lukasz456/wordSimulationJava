import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class World {
    private int width;
    private int height;
    private ArrayList<Organism> organisms = new ArrayList<>();
    private int currentAge;
    private char[][] board;
    private ActionHandler actionHandler;
    private int round;
    private boolean isHumanAlive;

    public World(int w, int h) {
        width = w;
        height = h;
        board = new char[Utiles.SIZE][Utiles.SIZE];
        actionHandler = new ActionHandler(this);
        currentAge = 0;
        round = 0;
        isHumanAlive = true;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                board[i][j] = '.';
            }
        }
    }

    public void makeTurn() {
        actionHandler.handleActions();
        round++;
    }

    public void drawWorld() {
        System.out.print("+");
        for (int i = 0; i < Utiles.SIZE; ++i) {
            System.out.print('-');
        }
        System.out.println("+");

        for (int i = 0; i < Utiles.SIZE; i++) {
            System.out.print("|");
            for (int j = 0; j < Utiles.SIZE; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("|");
        }

        System.out.print("+");
        for (int i = 0; i < Utiles.SIZE; ++i) {
            System.out.print("-");
        }
        System.out.println("+");
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setIsHumanAlive(boolean alive) {
        isHumanAlive = alive;
    }

    public boolean getIsHumanAlive() {
        return isHumanAlive;
    }

    public Organism getField(int... cords) {
        for (int i = 0; i < organisms.size(); i++) {
            if (organisms.get(i).getX() == cords[0] && organisms.get(i).getY() == cords[1]) {
                return organisms.get(i);
            }
        }
        return null;
    }

    public Organism[] getSurroundingFields(int x, int y) {
        Organism[] surrounding_fields = new Organism[4];

        for (int i = 0; i < 4; ++i) {
            surrounding_fields[i] = null;
        }

        if (y >= 1) {
            surrounding_fields[0] = getField(x, y - 1);
        }
        if (y < height - 1) {
            surrounding_fields[1] = getField(x, y + 1);
        }
        if (x >= 1) {
            surrounding_fields[2] = getField(x - 1, y);
        }
        if (x < width - 1) {
            surrounding_fields[3] = getField(x + 1, y);
        }

        return surrounding_fields;
    }

    public int addOrganism(Organism organism) {
        organisms.add(organism);
        organism.draw();
        actionHandler.addedOrganism();
        currentAge++;
        return currentAge - 1;
    }

    public int getCurrentAge() {
        return currentAge;
    }

    public void draw(int x, int y, char species) /*throws RangeException*/ {
        /*if (x < 0 || x >= width || y < 0 || y >= height) {
            // throwing the error to the stack trace
            throw new RangeException("World::draw - x and y out of bounds");
        }*/
        board[y][x] = species;
    }

    public List<Organism> getOrganisms() {
        return organisms;
    }

    public void killOrganism(int loser) {
        organisms.remove(loser);
    }

    public void killOrganism(Organism organism) {
        organisms.remove(organism);
    }

    public void gotoxy(int x, int y) {
        System.out.print(String.format("\033[%d;%dH", y + 1, x + 1));
    }
}

