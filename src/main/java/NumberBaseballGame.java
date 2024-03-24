import domain.NumberBaseballGameRound;
import domain.dto.GameResult;
import util.numberGenerator.RandomNumberGenerator;

import java.util.List;
import java.util.Scanner;

import static util.converter.IntegerListConverter.mapToInts;
import static util.validator.NumberBaseballGameInputValidator.*;
import static view.NumberBaseballGameView.*;

public class NumberBaseballGame {

    private final NumberBaseballGameRound round;
    private final Scanner scanner;
    private boolean gameStatus = true;

    public NumberBaseballGame() {
        this.round = new NumberBaseballGameRound(new RandomNumberGenerator());
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (!this.isFinished()) {
            round.init();
            doRound();
            afterRound();
        }
    }


    /**
     * doRound
     */
    private void doRound() {
        while (!round.isFinished()) {
            String inputString = getInput();

            if (isValid(inputString)) continue;

            GameResult result = processInput(inputString);
            evaluateResult(result);
        }
    }

    private String getInput() {
        printInputMessage();
        return scanner.next();
    }

    private static boolean isValid(String inputString) {
        try {
            validateNumbersInput(inputString);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    private GameResult processInput(String inputString) {
        List<Integer> integers = mapToInts(inputString, "");
        GameResult result = round.judge(integers);
        printResult(result.getStrikeCount(), result.getBallCount());
        return result;
    }

    private void evaluateResult(GameResult result) {
        if (result.getStrikeCount() == 3) {
            printSuccessMessage();
            round.finish();
        }
    }


    /**
     * afterRound
     */
    private void afterRound() {
        String inputString = getContinueGameInput();

        boolean validInput = false;
        while (!validInput) {
            try {
                validateContinueGameInput(inputString);
                validInput = true;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                inputString = getContinueGameInput();
            }
        }

        evaluateInputString(inputString);
    }

    private String getContinueGameInput() {
        printContinueGameNotificationMessage();
        return scanner.next();
    }

    private void evaluateInputString(String inputString) {
        if ("2".equals(inputString)) {
            this.finish();
        }
    }


    /**
     * common methods
     */
    private void finish() {
        this.gameStatus = false;
    }

    private boolean isFinished() {
        return !this.gameStatus;
    }
}
