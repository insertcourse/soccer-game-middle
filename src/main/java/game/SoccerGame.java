package game;

import entity.Attacker;
import entity.GoalKeeper;
import entity.Midfielder;
import entity.Striker;
import vo.Name;
import vo.Winner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoccerGame {
    private Winner winner;
    private List<Attacker> attackers = new ArrayList<>();
    private GoalKeeper goalKeeper;
    private Integer matchpoint = 0;
    private Integer currentpoint = 0;

    Scanner sc = new Scanner(System.in);

    private void settingPlayers() {
        setStrikers();
        setMidfielders();
        setGoalKeepers();
    }

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

    private void settingMatchPoint() {
        System.out.print("매치포인트를 입력하세요: ");
        matchpoint = sc.nextInt();
    }
    private void shooting() {
        for(Attacker attacker : attackers){
            tryGoal(attacker);
            updateCurrentPoints(attacker);
        }
    }

    private void tryGoal(Attacker attacker){
        List<Integer> shoots = tryShoot(attacker);
        List<Integer> keeps = tryKeep(goalKeeper);

        if(checkGoal(attacker, keeps, shoots)){
            attacker.addGoals();
        }
    }

    private boolean checkGoal(Attacker attacker, List<Integer> keeps, List<Integer> shoots){
        Integer chance = 0;
        for(Integer shoot : shoots){
            chance += isKeepShoot(keeps, shoot);
        }

        if(chance == shoots.size()){
            return true;
        }
        return false;
    }

    private Integer isKeepShoot(List<Integer> keeps, Integer shoot){
        if(!keeps.contains(shoot)){
            return 1;
        }
        return 0;
    }

    private List<Integer> tryShoot(Attacker attacker){
        List<Integer> shoots = new ArrayList<>();
        for(int i = 0; i < attacker.getChance(); i++){
            Integer shoot = (int)(Math.random()*10);
            shoots.add(shoot);
        }
        return shoots;
    }

    private List<Integer> tryKeep(GoalKeeper goalKeeper){
        List<Integer> keeps = new ArrayList<>();
        for(int i = 0; i < goalKeeper.getChance(); i++){
            Integer keep = (int)((Math.random()*4)+3);
            keeps.add(keep);
        }
        return keeps;
    }

    private void updateCurrentPoints(Attacker attacker){
        if(currentpoint < attacker.getGoals()){
            currentpoint = attacker.getGoals();
            setWinner(attacker.getName());
        }
    }

    private void printShooting(Integer cnt){
        System.out.println("\n" + cnt + "번째 슈팅결과");
        for(Attacker attacker : attackers){
            printAttackerGoals(attacker);
        }
    }

    private void printAttackerGoals(Attacker attacker){
        System.out.print(attacker.getName().getName() + ": ");
        for(int i = 0; i < attacker.getGoals(); i++){
            System.out.print("-");
        }
        System.out.println();
    }

    private void setWinner(Name name) {
        this.winner = new Winner(name.getName());
    }

    private void finish(){
        winner.printWinner();
    }

    public void init() {
        settingPlayers();
        settingMatchPoint();
    }

    public void start() {

        Integer cnt = 1;
        while(matchpoint > currentpoint){
            shooting();
            printShooting(cnt++);
        }
        finish();
    }
}
