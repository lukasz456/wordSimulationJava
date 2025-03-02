
public abstract class Organism {
    protected World world;
    protected int strength;
    protected int x, y;
    protected int initiative;
    protected int age;

    public Organism(int x, int y, World w, int i, int a, int strength) {
        this.x = x;
        this.y = y;
        this.initiative = i;
        this.strength = strength;
        this.world = w;
        this.age = world.addOrganism(this);
    }

    public abstract void action();

    public void draw() {
        world.draw(x, y, Utiles.EMPTY);
    }

    public void clear_prev_position() {
        world.draw(x, y, Utiles.EMPTY);
    }

    public int getInitiative() {
        return initiative;
    }

    public int getAge() {
        return age;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getStrength() {
        return strength;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void increaseStrength() {
        strength += 3;
    }

    public Utiles.Outcome collision(Organism attacker) {
        if (attacker.getStrength() > strength) {
            return Utiles.Outcome.ATTACKER_WINS;
        } else if (attacker.getStrength() < strength) {
            return Utiles.Outcome.DEFENDER_WINS;
        } else {
            return Utiles.Outcome.ATTACKER_WINS;
        }
    }

}
