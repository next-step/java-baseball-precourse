package baseball.controller;

import baseball.model.BaseBallGame;
import baseball.model.CompareResult;
import baseball.model.enums.PlayerStatus;
import baseball.model.enums.UserSelect;

import java.util.List;

public class Player {
    private PlayerStatus status;
    private BaseBallGame baseBallGame;

    public Player() {
        this.status = PlayerStatus.READY;
    }

    public boolean isReady() {
        return status.isReady();
    }

    public boolean isPlayingWithWrongAnswer() {
        return status.isPlaying() && baseBallGame.isWrongAnswer();
    }

    public boolean alreadyGetRightAnswer() {
        return status.isPlaying() && baseBallGame.isRightAnswer();
    }

    public void startNewGame(List<Integer> numbers) {
        baseBallGame = new BaseBallGame(numbers);
        status = PlayerStatus.PLAYING;
    }

    public String guessAnswer(String input) {
        try {
            CompareResult result = baseBallGame.tryCompare(input);
            return result.convertMessage();
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    public void restartOrExit(UserSelect userSelect) {
        if (userSelect != null) {
            status = userSelect.afterPlayerStatus();
        }
    }
}
