package entity;

import vo.Name;

public class GoalKeeper extends Player{
    public GoalKeeper(String name) {
        super(name, 3);
    }

    public Integer saves() {
        return (int)(Math.random()*10);
    }
}
