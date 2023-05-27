import java.util.Random;

public class Midfielder extends Player{ //Player 클래스 상속
    Random random = new Random();

    public Midfielder(String name) {
        super(name); //부모클래스로 보내짐
    }

    @Override //어노테이션
    public boolean shoot(Goalkeeper goalkeeper) {
        int shoot = random.nextInt(11); // 0부터 10미만
        boolean shootBlock = goalkeeper.block(shoot);
        if(shootBlock) {
            goal(); //shootBlock이 true라면 골에 값 추가
            return true;
        }
        return false;
    }
}