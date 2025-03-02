import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ActionHandler {
    private World world;

    public ActionHandler(World world) {
        this.world = world;
    }

    public int checkPosition(int index, List<Organism> organisms) {
        for (int i = 0; i < organisms.size(); i++) {
            if (index == i) {
                continue;
            }

            if (organisms.get(index).getX() == organisms.get(i).getX()
                    && organisms.get(index).getY() == organisms.get(i).getY()) {
                return i;
            }
        }
        return -1;
    }

    public void sortByInitiativeAge(List<Organism> organisms) {
        Collections.sort(organisms, new Comparator<Organism>() {
            @Override
            public int compare(Organism a, Organism b) {
                if (a.getInitiative() == b.getInitiative()) {
                    return a.getAge() - b.getAge();
                }
                return b.getInitiative() - a.getInitiative();
            }
        });
    }

    public void handleActions() {
        List<Organism> organisms = world.getOrganisms();
        int currentAge = world.getCurrentAge();
        for (int attacker_id = 0; attacker_id < organisms.size(); ++attacker_id) {
            if (organisms.get(attacker_id).getAge() >= currentAge) {
                continue;
            }
            organisms.get(attacker_id).action();
            int occupant = checkPosition(attacker_id, organisms);
            if (occupant != -1) {
                Utiles.Outcome outcome = organisms.get(occupant).collision(organisms.get(attacker_id));
                if (outcome == Utiles.Outcome.ATTACKER_WINS) {
                    System.out.println("organism: " + attacker_id + ", killed organism: " + occupant);
                    world.killOrganism(occupant);
                    if (attacker_id > occupant) {
                        --attacker_id;
                    }
                } else if (outcome == Utiles.Outcome.DEFENDER_WINS) {
                    System.out.println("organism: " + occupant + ", killed organism: " + attacker_id);
                    world.killOrganism(attacker_id);
                    if (attacker_id > occupant) {
                        --attacker_id;
                    }
                } else if (outcome == Utiles.Outcome.REFLECTION) {
                    System.out.println("Turtle reflected attack of organism: " + attacker_id);
                    continue;
                } else if (outcome == Utiles.Outcome.ESCAPE) {
                    System.out.println("Antilope escaped from the attack of organism: " + attacker_id);
                    organisms.get(occupant).clear_prev_position();
                    Utiles.randomNeighbourAntilope(organisms.get(occupant).getX(), organisms.get(occupant).getY());
                } else if (outcome == Utiles.Outcome.GUARANA_BOOST) {
                    System.out.println("organism: " + attacker_id + " has guarana boost!");
                    world.killOrganism(occupant);
                    if (attacker_id > occupant) {
                        --attacker_id;
                    }
                    organisms.get(attacker_id).increaseStrength();
                }
            }
        }
    }

    public void addedOrganism() {
        List<Organism> organisms = world.getOrganisms();
        sortByInitiativeAge(organisms);
    }
}
