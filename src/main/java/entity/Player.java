package entity;

import vo.Name;
import vo.Winner;

public class Player {
    private Name name;

    private static Integer chance = 0;

    public Player(String name) {
        this.name = new Name(name);
    }

    public Name getName() {
        return name;
    }

    public static Integer getChance() {
        return chance;
    }

    public static void setChance(Integer chance) {
        Player.chance = chance;
    }
}
