package vo;

public class Winner {
    private final String winner;

    public Winner(String winner) {
        this.winner = winner;
    }

    public String getWinner() {
        return winner;
    }

    public void printWinner() {
        System.out.println("승리자는 " + winner + "입니다.");
    }
}
