package game;

import entity.Attacker;
import entity.GoalKeeper;
import entity.Midfielder;
import entity.Striker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoccerGameManager {
    Scanner sc = new Scanner(System.in);
    private List<Attacker> attackers = new ArrayList<>();
    private GoalKeeper goalKeeper;
    private Integer matchpoint = 0;
    private void setStrikers() {
        System.out.print("공격수의 이름을 입력하세요: ");
        List<String> strikers = Arrays.stream(sc.nextLine().split(", "))
                .collect(Collectors.toCollection(ArrayList::new));

        for(String player : strikers){
            attackers.add(new Striker(player));
        }
    }

    private void setMidfielders() {
        System.out.print("미드필더의 이름을 입력하세요: ");
        List<String> midfielders = Arrays.stream(sc.nextLine().split(", "))
                .collect(Collectors.toCollection(ArrayList::new));

        for(String player : midfielders){
            Midfielder midfielder = new Midfielder(player);
            attackers.add(midfielder);
        }
    }

    private void setGoalKeepers() {
        System.out.print("골키퍼의 이름을 입력하세요: ");
        String player = sc.next();

        goalKeeper = new GoalKeeper(player);
    }

    private void settingPlayers() {
        setStrikers();
        setMidfielders();
        setGoalKeepers();
    }

    private void settingMatchPoint() {
        System.out.print("매치포인트를 입력하세요: ");
        matchpoint = sc.nextInt();
    }

    public void init(){
        settingPlayers();
        settingMatchPoint();
    }

    public List<Attacker> getAttackers() {
        return attackers;
    }

    public GoalKeeper getGoalKeeper() {
        return goalKeeper;
    }

    public Integer getMatchpoint() {
        return matchpoint;
    }
}
