package baseball;

import java.util.List;

public class Record {
    List<Integer> answer;
    List<Integer> input;
    int strike;
    int ball;

    public Record(List<Integer> answer, List<Integer> input) {
        this.answer = answer;
        this.input = input;
        this.strike = 0;
        this.ball = 0;
    }

    public boolean checkFinished() {
        return strike == 3;
    }

    public void plusOneStrike() {
        this.strike++;
    }

    public void plusOneBall() {
        this.ball++;
    }

    public String renderResult() {
        if (this.strike == 0 && this.ball == 0) {
            return "낫싱";
        }
        return renderScore();
    }

    private String renderScore() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.strike != 0) {
            stringBuilder.append(this.strike).append("스트라이크 ");
        }
        if (this.ball != 0) {
            stringBuilder.append(this.ball).append("볼");
        }
        return stringBuilder.toString();
    }
}
