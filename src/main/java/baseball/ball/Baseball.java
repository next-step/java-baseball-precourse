package baseball.ball;

public class Baseball {
    String ball;

    protected Baseball() {
    }

    protected Baseball(String ball) {
        this.ball = ball;
    }

    public void setBall(String ball) {
        this.ball = ball;
    }

    public String getBall() {
        return ball;
    }

    public void checkValidation() {
        if (ball == null) throw new IllegalArgumentException();
        int ballLength = ball.length();
        if (ballLength != 3) throw new IllegalArgumentException();
    }
}
