import javax.accessibility.AccessibleTable;
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

        int matchPoint = inputMatchPoint();
        boolean bool = true;

        int count = 1;

        while(bool){
            System.out.printf("\n%d번째 슈팅결과\n", count);
            System.out.printf("%s: ", attacker1.getName());
            attacker1.shoot(keeper);
            System.out.printf("\n%s: ", attacker2.getName());
            attacker2.shoot(keeper);
            System.out.printf("\n%s: ", midfielder1.getName());
            midfielder1.shoot(keeper);
            System.out.printf("\n%s: ", midfielder2.getName());
            midfielder2.shoot(keeper);
            count++;
            bool = check(attacker1, attacker2, midfielder1, midfielder2, matchPoint);
        }

    }

    static String[] inputNames(String position){
        Scanner sc = new Scanner(System.in);
        System.out.printf("%s의 이름을 입력하세요 : ", position);
        String[] names = sc.nextLine().split(", ");

        return names;
    }

    static int inputMatchPoint(){
        Scanner sc = new Scanner(System.in);
        System.out.print("매치포인트를 입력하세요 : ");

        int matchPoint = sc.nextInt();

        return matchPoint;
    }

    static boolean check(Attacker attacker1, Attacker attacker2, Midfielder midfielder1, Midfielder midfielder2, int matchPoint){
        if (attacker1.getScore() == matchPoint){
            System.out.printf("\n\n승리자는 %s 입니다.", attacker1.getName());
            return false;
        }
        if (attacker2.getScore() == matchPoint){
            System.out.printf("\n\n승리자는 %s 입니다.", attacker2.getName());
            return false;
        }
        if (midfielder1.getScore() == matchPoint){
            System.out.printf("\n\n승리자는 %s 입니다.", midfielder1.getName());
            return false;
        }if (midfielder2.getScore() == matchPoint){
            System.out.printf("\n\n승리자는 %s 입니다.", midfielder2.getName());
            return false;
        }
        return true;
    }

}
