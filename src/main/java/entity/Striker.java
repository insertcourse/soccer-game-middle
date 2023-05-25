package entity;

import vo.Name;

public class Striker extends Attacker {
    public Striker(String name) {
        super(name);
        setChance(2);
    }
}
