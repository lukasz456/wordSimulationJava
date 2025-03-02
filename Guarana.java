public class Guarana extends Plant {

    public Guarana(int x, int y, World w, int age) {
        super(x, y, w, age, 0);
        world.draw(x, y, Utiles.GUARANA);
    }

    @Override
    public Utiles.Outcome collision(Organism attacker) {
        if (attacker.getStrength() >= strength) {
            return Utiles.Outcome.GUARANA_BOOST;
        }
        return Utiles.Outcome.OTHER;
    }

    @Override
    public Guarana newPlant(int x, int y) {
        return new Guarana(x, y, world, 0);
    }

    @Override
    public void draw() {
        world.draw(x, y, Utiles.GUARANA);
    }
}
