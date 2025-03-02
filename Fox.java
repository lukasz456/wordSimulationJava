import java.util.Random;

public class Fox extends Animal {
    public Fox(int x, int y, World w, int age) {
        super(x, y, w, 7, age, 3);
        world.draw(x, y, Utiles.FOX);
    }

    @Override
    public void action() {
        int new_x = x;
        int new_y = y;

        Organism[] surrounding_fields = world.getSurroundingFields(x, y);
        int[] random_values = { -1,-1,-1,-1 };
        while (true) {
            int i = new Random().nextInt(4);
            if (random_values[0] != -1 && random_values[1] != -1 && random_values[2] != -1 && random_values[3] != -1) {
                break;
            }
            if (random_values[i] != -1) {
                continue;
            }
            random_values[i] = 0;
            if (surrounding_fields[i] == null) {
                clear_prev_position();
                if (i == 0) {
                    if (x > 1) {
                        x--;
                    }
                } else if (i == 1) {
                    if (x < Utiles.SIZE-2) {
                        x++;
                    }
                } else if (i == 2) {
                    if (y > 1) {
                        y--;
                    }
                } else {
                    if (y < Utiles.SIZE-2) {
                        y++;
                    }
                }
                world.draw(x, y, Utiles.FOX);
                break;
            } else {
                if (surrounding_fields[i].getStrength() <= strength) {
                    clear_prev_position();
                    if (i == 0) {
                        if (x > 1) {
                            x--;
                        }
                    } else if (i == 1) {
                        if (x < Utiles.SIZE - 1) {
                            x++;
                        }
                    } else if (i == 2) {
                        if (y > 1) {
                            y--;
                        }
                    } else {
                        if (y < Utiles.SIZE - 1) {
                            y++;
                        }
                    }
                    world.draw(x, y, Utiles.FOX);
                    break;
                }
            }
        }
    }
}
