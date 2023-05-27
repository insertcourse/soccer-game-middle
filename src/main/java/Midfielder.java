import java.util.Random;

public class Midfielder extends SoccerPlayer {
    Midfielder(String name) {
        super(name);
    }

    public void shoot(Keeper keeper) {
        Random random = new Random();

        int shoot = random.nextInt(11);

        boolean shootBool = keeper.block(shoot);

        if (shootBool){
            goal();
        }

        printScore();
    }
}
