import java.util.Scanner;

public class SoccerGameApplication {
    public static void main(String[] args) {
        String[] names = inputNames("공격수");
        Attacker attacker1 = new Attacker(names[0]);
        Attacker attacker2 = new Attacker(names[1]);

        names = inputNames("미드필더");
        Midfielder midfielder1 = new Midfielder(names[0]);
        Midfielder midfielder2 = new Midfielder(names[1]);

        names = inputNames("골키퍼");
        Keeper keeper = new Keeper(names[0]);

    }

    static String[] inputNames(String position){
        Scanner sc = new Scanner(System.in);
        System.out.printf("%s의 이름을 입력하세요 : ", position);
        String[] names = sc.nextLine().split(", ");

        return names;
    }
}
