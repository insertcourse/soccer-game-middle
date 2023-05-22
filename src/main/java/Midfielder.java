import java.util.Random;

public class Midfielder extends Soccer{
    Midfielder(String name){
        super(name);
    }

    public boolean shoot(){
        Random random = new Random();

        int shoot = random.nextInt(10);

        return true;
    }
}
