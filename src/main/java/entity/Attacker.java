package entity;

import vo.Name;
import vo.Winner;

public abstract class Attacker extends Player {
    private Integer goals = 0;
    public Attacker(String name, Integer chance) {
        super(name, chance);
    }

    public Integer shoot(){
        return (int)(Math.random()*10);
    }

    public Integer getGoals() {
        return goals;
    }

    public void addGoals() {
        goals += 1;
    }
}
