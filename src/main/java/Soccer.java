public abstract class Soccer{
    private String name;
    private int score;

    Soccer(String name){
        this.name = name;
        this.score = 0;
    }
    public String getName(){
        return name;
    }

    public void goal(){
        this.score += 1;
    }

    abstract boolean shoot(Keeper keeper);

    public int getScore() { return score; }

    public void print(int score){
        for(int i = 0; i < score; i++){
            System.out.print("-");
        }
    }

}
