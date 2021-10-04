package baseball;

public class Result {
    int strike;
    int ball;

    public boolean isCorrect() {
        return strike == 3;
    }
}
