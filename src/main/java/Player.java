abstract public class Player{
    private String name;
    private int score;

    public Player(String name) {
        this.name = name; 
        this.score = 0; //스코어 초기화
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public abstract boolean shoot(Goalkeeper goalkeeper); //추상클래스

    public void goal() {
        score ++; //스코어에 값 더함
    }
}