package baseball.score;

public enum Score {
    START(1),
    END(9),
    SELECT(3);
    public int num;

    Score(int num) {
        this.num = num;
    }
}
