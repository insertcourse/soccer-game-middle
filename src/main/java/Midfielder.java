import java.util.Random;

public class Midfielder extends Player{
    Random random = new Random();

    public Midfielder(String name) {
        super(name);
    }

    public boolean shoot(Goalkeeper goalkeeper) {
        int shoot = random.nextInt(11); // 0 ~ 10
        if(goalkeeper.block(shoot)) {
            goal();
            return true;
        }
        return false;
    }
}
