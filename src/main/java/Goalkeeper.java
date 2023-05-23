import javax.management.relation.RelationNotification;
import java.util.Random;

public class Goalkeeper extends Player {
    private int chance;
    Random random = new Random();
    public Goalkeeper(String name) {
        super(name);
        this.chance = 3;
    }

    public boolean shoot(Goalkeeper goalkeeper) {
        return false;
    }

    public boolean block(int shoot) {
        int keeperBlock = random.nextInt(5) + 3;
        if(shoot >= 3 && shoot <= 7 && chance > 0) {
            chance --;
            return keeperBlock != shoot;
        }
        if(shoot <  2 || shoot > 8 ) {
            return false;
        }
        return true;
    }
}
