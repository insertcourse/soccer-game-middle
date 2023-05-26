import java.util.Random;

public class Keeper {
    private String name;
    private int keep_count = 3;
    Keeper(String name){
        this.name = name;
    }

    public boolean block(int shoot){
        Random random = new Random();
        int blockShoot = random.nextInt(5) + 3;
        if (shoot >= 2 && shoot <= 7 && keep_count > 0){
            keep_count -= 1;
            return shoot != blockShoot;
        }
        if (shoot >= 2 && shoot <= 8){
            return true;
        }
        return false;
    }


}
