import java.util.Random;

public class Attacker extends Soccer{
    Attacker(String name){
        super(name);
    }

    @Override
    public boolean shoot(){
        Random random = new Random();

        int shoot1 = random.nextInt(10);
        int shoot2 = random.nextInt(10);

        return true;
    }
}
