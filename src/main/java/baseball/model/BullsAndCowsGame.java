package baseball.model;

public class BullsAndCowsGame {

    private final Answer answer;

    public BullsAndCowsGame(Answer answer) {
        if (answer == null)
            throw new IllegalArgumentException("정답이 잘못되었습니다.");
        this.answer = answer;
    }

    public Result challenge(Trial trial) {
        if (answer == null)
            throw new IllegalStateException("게임이 초기화 되지 않았습니다.");
        if (trial == null)
            throw new IllegalArgumentException("입력이 잘못되었습니다.");
        return answer.challenge(trial);
    }
}
