import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoccerGameApplication {
    static String winner = null;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Player> players = new ArrayList<>();
        List<String> attackers = getPlayers(scanner,"공격수");
        List<String> midfielders = getPlayers(scanner,"미드필더");
        List<String> goalkeepers = getPlayers(scanner,"골키퍼");
        int matchPoint = getMatchPoint(scanner);

        for(String attacker : attackers) {
            players.add(new Attacker(attacker));
        }

        for(String midfielder : midfielders) {
            players.add(new Midfielder(midfielder));
        }

        players.add(new Goalkeeper(goalkeepers.get(0)));
        shootResult(players,matchPoint);
    }

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
