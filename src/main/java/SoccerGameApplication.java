import player.Goalkeeper;
import player.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static soccerGameLogic.PlayerScanner.*;
import static soccerGameLogic.ShootResultPrinter.*;

public class SoccerGameApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> attackers = getPlayers("공격수");
        List<String> midfielders = getPlayers("미드필더");
        List<String> goalkeepers = getPlayers("골키퍼");
        List<Player> players = playerList(attackers,midfielders,goalkeepers);
        int matchPoint = getMatchPoint();

        shootResult(players,matchPoint);
    }
}
