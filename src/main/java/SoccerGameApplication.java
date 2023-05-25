import game.SoccerGame;

public class SoccerGameApplication {
    public static void main(String[] args) {
        SoccerGame soccerGame = new SoccerGame();

        try {
            soccerGame.init();
            soccerGame.start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
