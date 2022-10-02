package baseball.model;

import java.util.List;

public class UserResult {

    private int strike = 0;
    private int ball = 0;

    public void setScore(List<Ball> computer, Ball user, int index) {
        if (computer.get(index).getNumber() == (user.getNumber())) {
            strike();
            return;
        }

        for (int i = 0; i < computer.size(); i++) {
            ball(computer.get(i).getNumber(), user.getNumber());
        }
    }

    private void strike() {
        this.strike++;
    }

    private void ball(int answer, int user) {
        if (answer == user) {
            this.ball++;
        }
    }

    public String getResult() {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        if (strike == 0) {
            return ball + "볼";
        }
        if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }

    public boolean isClear() {
        return this.strike == 3;
    }
}
