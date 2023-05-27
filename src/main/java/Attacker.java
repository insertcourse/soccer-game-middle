import java.util.Random;

public class Attacker extends Player{ //Player 클래스 상속
    Random random = new Random();
    public Attacker(String name) {
        super(name); //부모클래스로 보내짐
    }
    @Override //어노테이션
    public boolean shoot(Goalkeeper goalkeeper) {
        int shoot1 = random.nextInt(11); // 0부터 10미만
        int shoot2 = random.nextInt(11); // 0부터 10미만

        if(goalkeeper.block(shoot1) || goalkeeper.block(shoot2)) { //goalkeeper가 슛을 한번이라도 막았을때 true 반환
            goal();
            return true; //return시 종료
        }
        return false; //return시 종료
    }
}