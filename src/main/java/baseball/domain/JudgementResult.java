package baseball.domain;

public class JudgementResult {
    private int strike = 0;
    private int ball = 0;

    public void add(CompareResult result) {
        if (result.isStrike()) {
            strike++;
        }
        if (result.isBall()) {
            ball++;
        }
    }

    public boolean isPlayerWin() {
        return this.strike == 3;
    }

    private boolean isNothing() {
        return this.strike == 0 && this.ball == 0;
    }

    @Override
    public String toString() {
        if (isNothing()) {
            return "낫싱";
        }
        StringBuilder sb = new StringBuilder();
        if (this.ball > 0) {
            sb.append(String.format("%d볼 ", this.ball));
        }
        if (this.strike > 0) {
            sb.append(String.format("%d스트라이크", this.strike));
        }
        return sb.toString();
    }
}
