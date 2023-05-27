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
        if(chance > 0) {
            return check(shoot,keeperBlock);
        }
        return true;
    }

    public boolean check(int shoot,int keeperBlock) {
        if(shoot == keeperBlock || shoot < 2 || shoot > 8) {
            chance --;
            return false;
        }
        return true;
    }
}
