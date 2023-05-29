package soccerGameLogic;

import player.Player;
import java.util.ArrayList;
import java.util.List;

public class WinnerPrinter {
    public static boolean CheckMatchPoint(List<Player> players, int matchPoint) {
        List<Integer> scores = new ArrayList<>();
        int winnerIndex = 0;
        for(Player player : players) {
            scores.add(player.getScore());
        }
        winnerIndex = scores.indexOf(matchPoint);
        if(winnerIndex != -1) {
            System.out.println("\n\n승리자는 " + players.get(winnerIndex).getName() + " 입니다.");
            return false;
        }
        return true;
    }
}
