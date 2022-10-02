package baseball.computer;

public class Score {

    private final int position;
    private final int score;

    public Score(int score, int position) {
        this.score = score;
        this.position = position;
    }

    public int getScore() {
        return this.score;
    }

    public boolean equals(Score score) {
        return this.position == score.position
                && this.score == score.score;
    }

    public boolean equalsScore(int score) {
        return this.score == score;
    }
}
