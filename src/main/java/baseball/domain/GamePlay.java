package baseball.domain;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static baseball.constant.ExceptionMessage.*;
import static baseball.constant.GameConfig.ANSWER_SIZE;
import static baseball.view.ConsoleInput.*;
import static baseball.view.ConsoleOutput.*;


public class GamePlay {

    private final List<Integer> playerNumbers;
    private final Set<Integer> playerNumberSet;
    private final Player player;
    private final Computer computer;

    public GamePlay() {
        playerNumbers = new LinkedList<>();
        playerNumberSet = new HashSet<>();
        player = new Player();
        computer = new Computer();
    }

    public boolean play() {

        while (!player.isWin()) {
            inputMessage();
            List<Integer> playerNumbers = initPlayerNumbers(player.inputNumber());
            player.setScore(computer.compareAnswers(playerNumbers));
            printResult(player.getScoreMessage());
        }

        return isRestart();
    }

    public List<Integer> initPlayerNumbers(final String playerInput) {
        String[] splitInput = playerInput.split("");

        clearPlayerNumbers();

        for (String input : splitInput) {
            Integer inputNumber = changeToInteger(input);
            playerNumbers.add(inputNumber);
            playerNumberSet.add(inputNumber);
        }

        validationCheck();

        return playerNumbers;
    }

    private boolean isRestart() {
        printGameEndMessage();
        restartInputMessage();

        return validateRestart(changeToInteger(player.inputNumber()));
    }

    private void clearPlayerNumbers() {
        playerNumbers.clear();
        playerNumberSet.clear();
    }

    private void validationCheck() {
        validateLength();
        validateNumberRange();
        validateDuplicate();
    }

    private Integer changeToInteger(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INVALID_NUMBER);
        }
    }

    private void validateLength() {
        if (playerNumbers.size() != ANSWER_SIZE ) {
            throw new IllegalArgumentException(INVALID_LENGTH);
        }
    }

    private void validateNumberRange() {
        for (Integer number : playerNumbers ) {
            checkNumberRange(number);
        }
    }

    private void checkNumberRange(final Integer number) {
        if (!(1 <= number && 9 >= number)) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    private void validateDuplicate() {
        if (playerNumberSet.size() != playerNumbers.size()) {
            throw new IllegalArgumentException(INVALID_DUPLICATE);
        }
    }

    private boolean validateRestart(final Integer number) {
        if (number == 1) {
            return true;
        }
        if (number == 2) {
            return false;
        }
        throw new IllegalArgumentException(INVALID_RESTART_INPUT);
    }
}
