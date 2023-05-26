package Application;

import domain.Attacker;
import domain.Goalkeeper;
import domain.Midfielder;
import domain.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameInitialize{
    private static final Scanner scanner = new Scanner(System.in);

    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        System.out.print("공격수의 이름을 입력하세요: ");
        String[] names = scanner.nextLine().split(", ");
        for (String name : names) {
            players.add(new Attacker(name));
        }
        System.out.print("미드필더의 이름을 입력하세요: ");
        names = scanner.nextLine().split(", ");
        for (String name : names) {
            players.add(new Midfielder(name));
        }
        return players;
    }

    public Goalkeeper getGoalkeeper(){
        System.out.print("골기퍼의 이름을 입력하세요:");
        String name = scanner.next();
        Goalkeeper goalkeeper = Goalkeeper.getInstance();
        goalkeeper.setName(name);
        return goalkeeper;
    }
    public int getMatchPoint() {
        System.out.print("매치포인트를 입력하세요:");
        return scanner.nextInt();
    }

}
