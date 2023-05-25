package game;

import entity.Attacker;
import entity.GoalKeeper;
import vo.Name;
import vo.Winner;

import java.util.ArrayList;
import java.util.List;

public class SoccerGameController {
    private Winner winner;
    private Integer currentpoint = 0;
    private SoccerGameManager soccerGameManager = new SoccerGameManager();
    private SoccerGameLogger soccerGameLogger = new SoccerGameLogger();
    private SoccerGameScoreManager soccerGameScoreManager = new SoccerGameScoreManager();
    private void shooting() {
        for(Attacker attacker : soccerGameManager.getAttackers()){
            soccerGameScoreManager.tryGoal(attacker, soccerGameManager.getGoalKeeper());
            updateCurrentPoints(attacker);
        }
    }

    private void updateCurrentPoints(Attacker attacker){
        if(currentpoint < attacker.getGoals()){
            currentpoint = attacker.getGoals();
            setWinner(attacker.getName());
        }
    }

    private void setWinner(Name name) {
        this.winner = new Winner(name.getName());
    }

    public void start() {
        soccerGameManager.init();

        Integer cnt = 1;
        while(soccerGameManager.getMatchpoint() > currentpoint){
            shooting();
            soccerGameLogger.printShooting(soccerGameManager.getAttackers(), cnt++);
        }
        soccerGameLogger.printWinner(winner);
    }
}
