package game;

import entity.Attacker;
import vo.Winner;

import java.util.List;

public class SoccerGameLogger {
    public void printShooting(List<Attacker> attackers, Integer cnt){
        System.out.println("\n" + cnt + "번째 슈팅결과");
        for(Attacker attacker : attackers){
            printAttackerGoals(attacker);
        }
    }

    public void printAttackerGoals(Attacker attacker){
        System.out.print(attacker.getName().getName() + ": ");
        for(int i = 0; i < attacker.getGoals(); i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinner(Winner winner){
        winner.printWinner();
    }
}
