package baseball.model;

import baseball.view.GameCommentView;
import baseball.vo.GameResultStatus;
import baseball.vo.RandomBaseballNumber;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class BaseballService {

    private RandomBaseballNumber randomBaseballNumber = new RandomBaseballNumber();
    private GameCommentView gameCommentView = new GameCommentView();

    public void initRandomBaseballNumber() {
        randomBaseballNumber.initNumber();
    }

    public int inputAnyNumber() {
        String inputNumberText = gameCommentView.inputAnyNumber();
        if (checkValidationInputNumber(inputNumberText)) {
            return Integer.parseInt(inputNumberText);
        }
        throw new IllegalArgumentException();
    }

    public GameResultStatus checkGameRuleInputNumberAndRandomNumber(int inputAnyNumber) {
        GameResultStatus gameResultStatus = new GameResultStatus();

        List<Integer> inputAnyNumbers = convertArrayByInputAnyNumber(inputAnyNumber);
        for (int idx = 0; idx < inputAnyNumbers.size(); idx++) {
            checkGameRuleEachDigitNumber(gameResultStatus, inputAnyNumbers.get(idx), idx);
        }
        gameResultStatus.checkBaseballGameResult();
        return gameResultStatus;
    }

    public void guideGameResult(GameResultStatus gameResultStatus) {
        gameCommentView.guideGameResult(gameResultStatus);
    }

    public boolean confirmRestartGame() {
        return gameCommentView.confirmRestartGame();
    }

    public boolean checkValidationInputNumber(String inputNumberText) {
        if (!checkNotEmptyInputNumber(inputNumberText)) {
            return false;
        }
        if (!checkNumericInputNumber(inputNumberText)) {
            return false;
        }
        if (!checkLengthInputNumber(inputNumberText)) {
            return false;
        }
        return true;
    }

    private void checkGameRuleEachDigitNumber(GameResultStatus gameResultStatus, int targetNumber, int idx) {
        if (checkContainNumber(gameResultStatus, targetNumber)) {
            checkSameLocationNumber(gameResultStatus, targetNumber, idx);
        }
    }

    private boolean checkContainNumber(GameResultStatus gameResultStatus, int targetNumber) {
        if (randomBaseballNumber.checkContainNumber(targetNumber)) {
            gameResultStatus.addBallCount();
            return true;
        }
        return false;
    }

    private void checkSameLocationNumber(GameResultStatus gameResultStatus, int targetNumber, int idx) {
        if (randomBaseballNumber.checkSameLocationNumber(targetNumber, idx)) {
            gameResultStatus.minusBallCount();
            gameResultStatus.plusStrikeCount();
        }

    }

    public boolean checkNotEmptyInputNumber(String inputNumberText) {
        return StringUtils.isNotBlank(inputNumberText);
    }

    public boolean checkNumericInputNumber(String inputNumberText) {
        return inputNumberText.matches("[-+]?\\d*\\.?\\d+");
    }

    public boolean checkLengthInputNumber(String inputNumberText) {
        int inputNumberLength = inputNumberText.length();
        if (inputNumberLength != 3) {
            return false;
        }
        return true;
    }

    private List<Integer> convertArrayByInputAnyNumber(int inputAnyNumber) {
        List<Integer> inputAnyNumbers = new ArrayList<>();

        String[] numberTextArr = String.valueOf(inputAnyNumber).split("");
        for (String numberText : numberTextArr) {
            inputAnyNumbers.add(Integer.parseInt(numberText));
        }

        return inputAnyNumbers;
    }

}
