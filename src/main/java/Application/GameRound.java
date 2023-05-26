package Application;

import domain.Goalkeeper;
import domain.Player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameRound {
    private final List<Player> players;
    private final Goalkeeper goalkeeper;
    private final int matchScore;
    private int round;

    public GameRound() {
        GameInitialize gameInitialize = new GameInitialize();
        this.players = gameInitialize.getPlayers();
        this.goalkeeper = gameInitialize.getGoalkeeper();
        this.matchScore = gameInitialize.getMatchPoint();
    }

    public boolean playRound(){
        nextRound();
        shootEachPlayer();
        presentRoundResult();
        return findWinner();
    }

    public void nextRound(){
        round++;
    }

    private void shootEachPlayer() {
        for (Player player : players) {
            IsGoal(player);
        }
    }

    private void IsGoal(Player player) {
        boolean isGoal = Arrays.stream(player.shoot())
                .anyMatch(goalkeeper.block()::contains);
        if (!isGoal) {
            player.addScore();
        }
    }

    private boolean findWinner() {
        List<Player> winner = players.stream()
                .filter(player -> player.getScore() > matchScore)
                .collect(Collectors.toList());

        if (winner.size() > 0) {
            winner.forEach(GameRound::presentWinner);
            return false;
        }
        return true;
    }

    private void presentRoundResult() {
        System.out.println(round + "번째 슈팅결과");
        players.forEach(GameRound::presentEachShootResult);
    }

    private static void presentWinner(Player player) {
        System.out.println("승리자는 " + player.getName() + " 입니다!");
    }

    private static void presentEachShootResult(Player player) {
        System.out.println(player.getName() + ": " + ("-".repeat(player.getScore())));
    }

}
