package domain;

import java.util.ArrayList;
import java.util.List;

public class Goalkeeper{
    public static Goalkeeper goalkeeper = null;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static Goalkeeper getInstance() {
        if(goalkeeper == null) {
            goalkeeper = new Goalkeeper();
        }
        return goalkeeper;
    }

    private Goalkeeper() {}

    public List<Integer> block(){
        List<Integer> blockList = new ArrayList<>();
        blockList.add((int) (Math.random() * 5) + 3);
        blockList.add((int) (Math.random() * 5) + 3);
        blockList.add((int) (Math.random() * 5) + 3);
        return blockList;
    }

}
