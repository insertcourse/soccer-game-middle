import java.util.Random;

public class Keeper {
    private String name;
    private int keep_count;
    Keeper(String name){
        this.name = name;
        this.keep_count = 3;
    }

    public boolean block(int shoot){
        Random random = new Random();
        int blockShoot = random.nextInt(5) + 3;
        if (shoot >= 2 && shoot <= 7 && keep_count > 0){
            boolean bool = check(shoot, blockShoot);
            return bool;
        }
        if (shoot >= 2 && shoot <= 8){
            return true;
        }
        return false;
    }


    public void setCount(){
        keep_count = 3;
    }

    public boolean check(int shoot, int blockShoot){
        if (shoot == blockShoot){
            keep_count--;
            return false;
        }
        return true;
    }


}
