package entity;

import vo.Name;
import vo.Winner;

public class Player {
    private Name name;
    private Integer chance = 0;

    public Player(String name, Integer chance) {
        this.name = new Name(name);
        this.chance = chance;
    }

    public Name getName() {
        return name;
    }

    public Integer getChance() {
        return chance;
    }
}
