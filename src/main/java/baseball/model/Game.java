package baseball.model;

public class Game {
    private int strike;
    private int ball;
    private int nothing;
    private Player user;
    private Player computer;

    public Game(Player user, Player computer) {
        this.user = user;
        this.computer = computer;
        computeGameResult();
    }

    private void computeGameResult() {
        this.strike = computeStrikeCount();
        this.ball = computeBallCount();
        this.nothing = computeNothingCount();
    }

    private int computeStrikeCount() {
        int strike = 0;

        for (int i = 0; i < computer.getNumbers().size(); i++) {
            strike += getOneWhenStrikeValue(computer.getNumbers().get(i)
                    , user.getNumbers().get(i));
        }

        return strike;
    }

    private int computeBallCount() {
        int ball = 0;

        for (int i = 0; i < computer.getNumbers().size(); i++) {
            int num = user.getNumbers().get(i);
            ball += getOneWhenBallValue(num);
        }

        return ball;
    }

    private int computeNothingCount() {
        int cnt = 0;

        for (int i = 0; i < computer.getNumbers().size(); i++) {
            cnt += getOneWhenNothing(user.getNumbers().get(i));
        }

        return (cnt == 3 ? 1 : 0);
    }

    private int getOneWhenStrikeValue(int num1, int num2) {
        if (num1 == num2) {
            return 1;
        }
        return 0;
    }

    private int getOneWhenBallValue(int num) {
        if ((computer.getNumbers().indexOf(num) > -1)
                && (computer.getNumbers().indexOf(num) != user.getNumbers().indexOf(num))) {
            return 1;
        }
        return 0;
    }

    private int getOneWhenNothing(int num) {
        if (computer.getNumbers().indexOf(num) > -1) {
            return 0;
        }
        return 1;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public int getNothing() {
        return nothing;
    }
}
