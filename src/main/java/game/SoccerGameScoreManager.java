package game;

import entity.Attacker;
import entity.GoalKeeper;

import java.util.ArrayList;
import java.util.List;

public class SoccerGameScoreManager {

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

    public void tryGoal(Attacker attacker, GoalKeeper goalkeeper){
        List<Integer> shoots = tryShoot(attacker);
        List<Integer> keeps = tryKeep(goalkeeper);

        if(checkGoal(attacker, keeps, shoots)){
            attacker.addGoals();
        }
    }
}
