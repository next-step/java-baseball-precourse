package baseball.tool;

public class Baseball implements Tool<Integer> {
    Integer ball;

    public Baseball(int value) {
        ball = value;
    }

    @Override
    public Integer getTool() {
        return ball;
    }

    @Override
    public void checkTool() {
        if (ball == 0 || ball == null) throw new IllegalArgumentException();
        int ballLength = String.valueOf(ball).length();
        if (ballLength != 3) throw new IllegalArgumentException();
    }
}
