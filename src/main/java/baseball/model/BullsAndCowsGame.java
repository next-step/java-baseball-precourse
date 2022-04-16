package baseball.model;

public class BullsAndCowsGame {

    private final Answer answer;
    private boolean end;

    public BullsAndCowsGame(Answer answer) {
        if (answer == null)
            throw new IllegalArgumentException("정답이 잘못되었습니다.");
        this.answer = answer;
        this.end = false;
    }

    public Result challenge(Trial trial) {
        if (trial == null)
            throw new IllegalArgumentException("입력이 잘못되었습니다.");
        Result challenge = answer.challenge(trial);
        if (challenge.getStrike() == 3)
            clear();
        return challenge;
    }

    public boolean isEnd() {
        return end;
    }

    private void clear() {
        end = true;
    }
}
