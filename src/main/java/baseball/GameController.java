package baseball;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Console;
import baseball.common.GameConfig;
import baseball.common.GameMessage;
import baseball.exception.GameException;

public class GameController {
    GameService computer;

    protected GameController() {
        computer = new GameService();
    }

    public void playGame() {
        boolean isPlayerWin;
        do {
            isPlayerWin = isFindTargetNumber();
        } while (!isPlayerWin);

        GameConsole.gameEnd();
    }

    private boolean isFindTargetNumber() {
        String proposalNumber;
        do {
            GameConsole.requestProposalNumber();
            proposalNumber = Console.readLine();
        } while (!isValidProposalNumber(proposalNumber));

        return computer.compareProposalNumber(makeIntegerList(proposalNumber));
    }

    public boolean askContinue() {
        String continueNumber;
        do {
            GameConsole.askContinue();
            continueNumber = Console.readLine();
        } while (!isValidContinueAnswer(continueNumber));

        return continueNumber.equals("1");
    }

    private boolean isValidProposalNumber(String proposalNumber) {
        try {
            checkNumericProposalNumber(proposalNumber);
            checkZeroInProposalNumber(proposalNumber);
        } catch (GameException ge) {
            GameConsole.printErrorMessage(ge.getMessage());
            return false;
        }

        return true;
    }

    private boolean isValidContinueAnswer(String continueNumber) {
        try {
            checkContinueAnswer(continueNumber);
        } catch (GameException ge) {
            GameConsole.printErrorMessage(ge.getMessage());
            return false;
        }

        return true;
    }

    private void checkNumericProposalNumber(String proposalNumber) throws GameException {
        String pattern = "[0-9]";
        for (int i = 0; i < GameConfig.RULE_NUMBER_COUNT.getNumber() - 1; i++) {
            pattern = pattern.concat("[0-9]");
        }

        if (!proposalNumber.matches(pattern)) {
            throw new GameException(GameMessage.NOT_NUMERIC_ERROR.getMessageWithNumber(
                    GameConfig.RULE_NUMBER_COUNT.getNumber()));
        }
    }

    private void checkZeroInProposalNumber(String proposalNumber) throws GameException {
        if (proposalNumber.contains("0")) {
            throw new GameException(GameMessage.CONTAIN_ZERO_ERROR.getMessage());
        }
    }

    private void checkContinueAnswer(String continueNumber) throws GameException {
        if (!(continueNumber.equals("1") || continueNumber.equals("2"))) {
            throw new GameException(GameMessage.INCORRECT_VALUE_ERROR.getMessage());
        }
    }

    private List<Integer> makeIntegerList(String proposalNumber) {
        String[] listOfNumberSting = proposalNumber.split("");
        List<Integer> intList = new ArrayList<>();

        for (String s : listOfNumberSting) {
            intList.add(Integer.parseInt(s));
        }
        return intList;
    }

}
