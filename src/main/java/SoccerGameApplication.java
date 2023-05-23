import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import static java.util.Arrays.*;

public class SoccerGameApplication {
    static String winner = null;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] attackers = getPlayers(scanner,"공격수");
        String[] midfielders = getPlayers(scanner,"미드필더");
        String[] goalkeepers = getPlayers(scanner,"골키퍼");
        int matchPoint = getMatchPoint(scanner);

        Attacker attacker1 = new Attacker(attackers[0]);
        Attacker attacker2 = new Attacker(attackers[1]);
        Midfielder midfielder1 = new Midfielder(midfielders[0]);
        Midfielder midfielder2 = new Midfielder(midfielders[1]);
        Goalkeeper goalkeeper = new Goalkeeper(goalkeepers[0]);

        Player[] players = {attacker1,attacker2,midfielder1,midfielder2,goalkeeper};
        shootResult(players,matchPoint);
    }

    public static void shootResult(Player[] players, int matchPoint) {
        int count = 1;
        boolean isGameOver = true;

        while(isGameOver) {
            System.out.println(count + "번째 슈팅 결과");
            printResult(players[0],new Goalkeeper(players[4].getName()));
            printResult(players[1],new Goalkeeper(players[4].getName()));
            printResult(players[2],new Goalkeeper(players[4].getName()));
            printResult(players[3],new Goalkeeper(players[4].getName()));
            System.out.println();

            int[] scores = {players[0].getScore(), players[1].getScore(), players[2].getScore(), players[3].getScore()};
            isGameOver = (ContainMatchPoint(players,scores,matchPoint) == null ? true : false );
            count ++;
        }
    }

    public static void printResult(Player players,Goalkeeper goalkeeper) {
        players.shoot(goalkeeper);
        System.out.println(players.getName() + ": " + "—".repeat(players.getScore()));

    }

    public static String ContainMatchPoint(Player[] players,int[] scores, int matchPoint) {
        if(Arrays.stream(scores).anyMatch(score -> score == matchPoint)) {
            int index = Arrays.stream(scores).boxed().mapToInt(Integer::intValue).boxed().collect(Collectors.toList()).indexOf(matchPoint);
            String winner = players[index].getName();
            System.out.println("승리자는 " + winner + " 입니다.");
            return winner;
        }
        return null;
    }

    public static String[] getPlayers(Scanner scanner,String type) {
        System.out.print(type + "의 이름을 입력하세요: ");
        return scanner.nextLine().split(", ");
    }

    public static int getMatchPoint(Scanner scanner) {
        System.out.print("매치포인트를 입력하세요: ");
        return scanner.nextInt();
    }
}
