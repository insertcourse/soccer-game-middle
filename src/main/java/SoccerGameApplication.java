import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SoccerGameApplication {
    public static void main(String[] args) {
        List<String> names = inputNames("공격수");
        Attacker attacker1 = new Attacker(names.get(0));
        Attacker attacker2 = new Attacker(names.get(1));

        names = inputNames("미드필더");
        Midfielder midfielder1 = new Midfielder(names.get(0));
        Midfielder midfielder2 = new Midfielder(names.get(1));

        names = inputNames("골키퍼");
        Keeper keeper = new Keeper(names.get(0));

        int matchPoint = inputMatchPoint();
        boolean isNotGameDone = true;

        int count = 1;

        List<SoccerPlayer> players = new ArrayList<SoccerPlayer>();
        players.add(attacker1);
        players.add(attacker2);
        players.add(midfielder1);
        players.add(midfielder2);

        while(isNotGameDone){
            System.out.printf("\n%d번째 슈팅결과", count);
            printResult(players, keeper);
            count++;
            isNotGameDone = players.stream()
                    .allMatch(player -> check(player, matchPoint));
            keeper.setCount();
        }

    }

    static void printResult(List<SoccerPlayer> players, Keeper keeper){
        for (SoccerPlayer soccer : players){
            System.out.printf("\n%s: ", soccer.getName());
            soccer.shoot(keeper);
        }
    }

    static boolean check(SoccerPlayer player , int matchPoint){
        if (player.getScore() == matchPoint){
            System.out.printf("\n\n승리자는 %s 입니다.", player.getName());
            return false;
        }
        return true;
    }

    static int inputMatchPoint(){
        Scanner sc = new Scanner(System.in);
        System.out.print("매치포인트를 입력하세요 : ");

        return sc.nextInt();
    }

    static List<String> inputNames(String position){
        Scanner sc = new Scanner(System.in);
        System.out.printf("%s의 이름을 입력하세요 : ", position);
        List<String> names = Arrays.asList(sc.nextLine().split(", "));

        return names;
    }

}
