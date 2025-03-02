import java.util.Scanner;

public class Human extends Animal {
    private boolean isPowerOn;
    private boolean powerAvailable;
    private int cooldown;

    public Human(int x, int y, World w, int age) {
        super(x, y, w, 4, age, 5);
        cooldown = 0;
        isPowerOn = false;
        powerAvailable = true;
        world.draw(x, y, Utiles.HUMAN);
    }

    @Override
    public void action() {
        clear_prev_position();
        if (isPowerOn == true && strength > 5) {
            strength--;
            if (strength == 5) {
                isPowerOn = false;
                cooldown = 5;
            }
        }
        if (cooldown > 0) {
            cooldown--;
            if (cooldown == 0) {
                powerAvailable = true;
            }
        }
        boolean correct_key = false;
        Scanner scanner = new Scanner(System.in);
        while (!correct_key) {
            switch (scanner.next().charAt(0)) {
                case 'w':
                    y--;
                    correct_key = true;
                    break;

                case 's':
                    ++y;
                    correct_key = true;
                    break;

                case 'd':
                    x++;
                    correct_key = true;
                    break;

                case 'a':
                    x--;
                    correct_key = true;
                    break;

                case 'p':
                    strength = 10;
                    isPowerOn = true;
                    powerAvailable = false;
                    break;
            }
        }
        world.draw(x, y, Utiles.HUMAN);
    }

    public void destructor() {
        world.setIsHumanAlive(false);
    }
}
