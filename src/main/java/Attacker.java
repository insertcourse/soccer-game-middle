import java.util.Random;

public class Attacker extends SoccerPlayer{
    Attacker(String name){
        super(name);
    }

    @Override
    public void shoot(Keeper keeper){
        Random random = new Random();

        int shoot1 = random.nextInt(11);
        int shoot2 = random.nextInt(11);

        if (keeper.block(shoot1) || keeper.block(shoot2)){
            goal();
        }

        print(getScore());
    }
}
