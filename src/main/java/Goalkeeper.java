import java.util.Random;

public class Goalkeeper extends Player { //Player 클래스 상속
    private int chance;
    Random random = new Random();
    public Goalkeeper(String name) {
        super(name); //부모클래스로 보내짐
        this.chance = 3;
    }

    public boolean shoot(Goalkeeper goalkeeper) {
        return false;
    } //추상클래스이지만 골키퍼는 슛을 차지 않아 false 반환

    public boolean block(int shoot) {
        int keeperBlock = random.nextInt(5) + 3;
        if(shoot >= 3 && shoot <= 7) {
            chance --;
            return keeperBlock != shoot; 
        } // 3이상 7이하일때 골키퍼의 block값과 같다면 false 다르다면 true 반환
        if(shoot <  2 || shoot > 8 ) {
            return false;
        } //2보다 작거나 8보다 클때는 무조건 false 출력
        return true;
    }
}