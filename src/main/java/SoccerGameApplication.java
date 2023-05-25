import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoccerGameApplication {
    static String winner = null;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> attackers = getPlayers(scanner,"공격수");
        List<String> midfielders = getPlayers(scanner,"미드필더");
        List<String> goalkeepers = getPlayers(scanner,"골키퍼");
        int matchPoint = getMatchPoint(scanner);

        Attacker attacker1 = new Attacker(attackers.get(0));
        Attacker attacker2 = new Attacker(attackers.get(1));
        Midfielder midfielder1 = new Midfielder(midfielders.get(0));
        Midfielder midfielder2 = new Midfielder(midfielders.get(1));
        Goalkeeper goalkeeper = new Goalkeeper(goalkeepers.get(0));

        shootResult(attacker1,attacker2,midfielder1,midfielder2,goalkeeper,matchPoint);
    }

    public static void shootResult(Attacker attacker1,Attacker attacker2,Midfielder midfielder1,Midfielder midfielder2,Goalkeeper goalkeeper, int matchPoint) {
        int count = 1;
        boolean isPlayingGame = true;

        while(isPlayingGame) {
            System.out.println(count + "번째 슈팅 결과");
            printResult(attacker1,goalkeeper);
            printResult(attacker2,goalkeeper);
            printResult(midfielder1,goalkeeper);
            printResult(midfielder2,goalkeeper);
            System.out.println();

            isPlayingGame = CheckMatchPoint(attacker1,matchPoint) &&
                    CheckMatchPoint(attacker2,matchPoint) &&
                    CheckMatchPoint(midfielder1,matchPoint) &&
                    CheckMatchPoint(midfielder2,matchPoint);
            count ++;
        }
    }

    public static void printResult(Player players,Goalkeeper goalkeeper) {
        players.shoot(goalkeeper);
        System.out.println(players.getName() + ": " + "—".repeat(players.getScore()));

    }

    public static boolean CheckMatchPoint(Player player, int matchPoint) {
        if(player.getScore() == matchPoint) {
            System.out.println("\n\n승리자는 " + player.getName() + " 입니다.");
            return false;
        }
        return true;
    }

    public static List<String> getPlayers(Scanner scanner,String type) {
        System.out.print(type + "의 이름을 입력하세요: ");
        List<String> players = Arrays.asList(scanner.nextLine().split(", "));
        return players;
    }

    public static int getMatchPoint(Scanner scanner) {
        System.out.print("매치포인트를 입력하세요: ");
        return scanner.nextInt();
    }
}
