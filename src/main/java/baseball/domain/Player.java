package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private Score score;

    public Player() {
        score = new Score();
    }

    public String inputNumber() {
        return Console.readLine();
    }

    public boolean isWin() {
        return score.isWin();
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public String getScoreMessage() {
        return score.getScoreMessage();
    }
}
