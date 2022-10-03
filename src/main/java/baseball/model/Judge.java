package baseball.model;

import baseball.domain.GameRule;
import java.util.ArrayList;

public class Judge {
    private GameResult gameResult;

    public Judge(ArrayList<Integer> randomNums, ArrayList<Integer> playerNums) {
        gameResult = new GameResult();
        for (int i=0; i < GameRule.MAX_LENGTH; i++) {
            addBall(i, playerNums.get(i), randomNums);
            addStrike(randomNums.get(i), playerNums.get(i));
        }
    }

    private void addBall(int randomNumIndex, Integer playerNum, ArrayList<Integer> randomNums) {
        if ((randomNums.get(randomNumIndex).intValue() != playerNum.intValue()) && randomNums.contains(playerNum)) {
            gameResult.updateResult("볼");
        }
    }

    private void addStrike(Integer randomNum, Integer playerNum) {
        if (randomNum.intValue() == playerNum.intValue()){
            gameResult.updateResult("스트라이크");
        }
    }

    public GameResult getGameResult() {
        return this.gameResult;
    }
}
