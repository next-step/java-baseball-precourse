package baseball.tool;

public class Baseball {
    Integer ball;

    protected Baseball(Integer ball) {
        this.ball = ball;
    }

    void checkValidation() {
        if (ball == null) throw new IllegalArgumentException();
        int ballLength = String.valueOf(ball).length();
        if (ballLength != 3) throw new IllegalArgumentException();
    }
}
