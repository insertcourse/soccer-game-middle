package Application;

public class GameStart {
    private final GameRound gameRound;

    private boolean isGameWhile = true;

    public GameStart() {
        this.gameRound = new GameRound();
    }

    public void gameStart() {
        while (isGameWhile) {
            isGameWhile = gameRound.playRound();
        }
    }
}
