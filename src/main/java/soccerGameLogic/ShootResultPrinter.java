package soccerGameLogic;

import player.Goalkeeper;
import player.Player;
import java.util.List;
import static soccerGameLogic.WinnerPrinter.*;

public class ShootResultPrinter {
    public static void shootResult(List<Player> players, int matchPoint) {
        int count = 1;
        boolean isPlayingGame = true;

        while(isPlayingGame) {
            System.out.println(count + "번째 슈팅 결과");
            printResult(players);
            System.out.println();
            isPlayingGame = CheckMatchPoint(players,matchPoint);
            count ++;
        }
    }

    public static void printResult(List<Player> players) {
        int index = 0;
        Goalkeeper goalkeeper = (Goalkeeper) players.get(4);
        players.remove(4); // 슈팅결과 골키퍼 출력 방지
        for(Player player : players) {
            player.shoot(goalkeeper);
            System.out.println(player.getName() + ": " + "—".repeat(player.getScore()));
        }
        players.add(goalkeeper);
    }
}
