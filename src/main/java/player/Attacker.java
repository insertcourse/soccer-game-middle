package player;

import java.util.Random;

public class Attacker extends Player{
    Random random = new Random();
    public Attacker(String name) {
        super(name);
    }

    public boolean shoot(Goalkeeper goalkeeper) {
        int shoot1 = random.nextInt(11);
        int shoot2 = random.nextInt(11);

        if(goalkeeper.block(shoot1) || goalkeeper.block(shoot2)) {
            goal();
            return true;
        }
        return false;
    }
}
