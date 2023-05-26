package domain;

public abstract class Player {
    private final String name;
    private int score;
    private final int chance;


    public Player(String name,int chance) {
        this.name = name;
        this.chance = chance;
    }

    public int[] shoot(){
        int[] arr = new int[chance];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10) +1;
        }
        return arr;
    }

    public int getScore() {
        return score;
    }

    public void addScore(){
        score++;
    }

    public String getName() {
        return name;
    }
}
