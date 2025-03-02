public class Animal extends Organism {

    public Animal(int x, int y, World w, int initiative, int age, int strength) {
        super(x, y, w, initiative, age, strength);
    }

    @Override
    public void action() {
        int new_x = x;
        int new_y = y;
        //randomize the animal's direction of movement
        //get field at the randomized position
        Utiles.randomNeighbour(new_x, new_y);

        //clear
        clear_prev_position();
        x = new_x;
        y = new_y;
        draw();
    }

    @Override
    public void draw() {
        world.draw(x, y, Utiles.ANIMAL);
    }

    @Override
    public Utiles.Outcome collision(Organism attacker) {
        if (attacker instanceof Animal) {
            world.gotoxy(50, 40);
            // new animal
            Organism[] surrounding_fields = world.getSurroundingFields(x, y);
            Animal a = null;
            int new_x = x;
            int new_y = y;
            for (int i = 0; i < 4; ++i) {
                if (surrounding_fields[i] == null) {
                    if (i == 0)
                        y--;
                    if (i == 1)
                        y++;
                    if (i == 3)
                        x++;
                    if (i == 2)
                        x--;
                    a = newAnimal(new_x, new_y);
                    return Utiles.Outcome.NEW_CHILD;
                }
            }
            return Utiles.Outcome.NO_CHILD;
        } else {
            return super.collision(attacker);
        }
    }

    public Animal newAnimal(int x, int y) {
        Animal n = new Animal(x, y, world, this.getInitiative(), 0, this.getStrength());
        return n;
    }
}
