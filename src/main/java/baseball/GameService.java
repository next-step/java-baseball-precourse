package baseball;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;
import baseball.common.GameConfig;

public class GameService {
    List<Integer> targetNumber;
    int targetDigit;

    protected GameService() {
        this.targetDigit = GameConfig.RULE_NUMBER_DIGIT.getNumber();
        this.targetNumber = makeRandomNumber();
    }

    public List<Integer> makeRandomNumber() {
        List<Integer> listOfNumber = new ArrayList<>();

        while (listOfNumber.size() < targetDigit) {
            int pickNumber = Randoms.pickNumberInRange(GameConfig.RULE_NUMBER_MIN.getNumber(), GameConfig.RULE_NUMBER_MAX.getNumber());
            addRandomNumber(listOfNumber, pickNumber);
        }

        return listOfNumber;
    }

    public boolean compareProposalNumber(List<Integer> proposalNumber) {
        int strikeCount = getStrikeCount(targetNumber, proposalNumber);
        int ballCount = getBallCount(targetNumber, proposalNumber, strikeCount);
        if (strikeCount == 0 && ballCount == 0) {
            GameConsole.resultNothing();
        }
        GameConsole.lineBreak();

        return strikeCount == targetDigit;
    }

    public void setTargetNumber(List<Integer> targetNumber) {
        this.targetNumber = targetNumber;
    }

    private int getStrikeCount(List<Integer> targetNumber, List<Integer> proposalNumber) {
        int strikeCount = 0;
        for (int i = 0; i < targetDigit; i++) {
            strikeCount = addStrikeCount(targetNumber.get(i), proposalNumber.get(i), strikeCount);
        }

        if (strikeCount != 0) {
            GameConsole.resultStrike(strikeCount);
        }

        return strikeCount;
    }

    private int getBallCount(List<Integer> targetNumber, List<Integer> proposalNumber, int strikeCount) {
        int ballCount = 0;

        for (int i = 0; i < targetDigit; i++) {
            ballCount = addBallCount(targetNumber.get(i), proposalNumber, ballCount, i);
        }

        if (ballCount != 0) {
            GameConsole.resultBall(ballCount, strikeCount == 0);
        }

        return ballCount;
    }

    private void addRandomNumber(List<Integer> listOfNumber, int pickNumber) {
        if (!listOfNumber.contains(pickNumber)) {
            listOfNumber.add(pickNumber);
        }
    }

    private int addStrikeCount(int targetNumber, int proposalNumber, int strikeCount) {
        if (targetNumber == proposalNumber) {
            strikeCount++;
        }

        return strikeCount;
    }

    private int addBallCount(int targetNumber, List<Integer> listOfProposalNumber, int ballCount, int index) {
        List<Integer> copyOfList = new ArrayList<>(listOfProposalNumber);
        if (targetNumber == copyOfList.get(index)) {
            copyOfList.remove(index);
        }

        if (copyOfList.contains(targetNumber)) {
            ballCount++;
        }

        return ballCount;
    }
}
