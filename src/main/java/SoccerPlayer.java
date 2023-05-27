public abstract class SoccerPlayer{
    private String name;
    private int score;

    SoccerPlayer(String name){
        this.name = name;
        this.score = 0;
    }
    public String getName(){
        return name;
    }

    public void goal(){
        this.score += 1;
    }

    abstract void shoot(Keeper keeper);

    public int getScore() { return score; }

    public void printScore(){
        for(int i = 0; i < score; i++){
            System.out.print("-");
        }
    }


}
