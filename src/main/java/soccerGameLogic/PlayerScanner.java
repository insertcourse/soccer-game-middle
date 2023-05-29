package soccerGameLogic;

import player.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PlayerScanner {
    static Scanner scanner = new Scanner(System.in);
    public static List<String> getPlayers(String type) {
        System.out.print(type + "의 이름을 입력하세요: ");
        List<String> players = Arrays.asList(scanner.nextLine().split(", "));
        return players;
    }

    public static int getMatchPoint() {
        System.out.print("매치포인트를 입력하세요: ");
        return scanner.nextInt();
    }

    public static List<Player> playerList(List<String> attackers, List<String> midfielders, List<String> goalkeepers) {
        List<Player> players = new ArrayList<>();

        for(String attacker : attackers) {
            players.add(new Attacker(attacker));
        }

        for(String midfielder : midfielders) {
            players.add(new Midfielder(midfielder));
        }

        players.add(new Goalkeeper(goalkeepers.get(0)));

        return players;
    }
}
