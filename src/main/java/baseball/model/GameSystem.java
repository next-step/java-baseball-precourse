package baseball.model;

import static baseball.Constant.CommonConstant.*;
import static baseball.Constant.MessageConstant.*;

import java.util.HashSet;
import java.util.Set;

public class GameSystem {
    private BaseballGame baseballGame;

    public void runGameSystem() {
        do {
            baseballGame = new BaseballGame();
            baseballGame.run();
        } while (wantReGame());
    }

    private Boolean wantReGame() {
        String reGameWord = GameGuidePrinter.printGameFinish();
        validateReGameWord(reGameWord);

        int reGameNum = Character.getNumericValue(reGameWord.charAt(0));
        return isReGame(reGameNum);
    }

    private boolean isReGame(int reGameNum) {
        if (reGameNum != 1 && reGameNum != 2) {
            throw new IllegalArgumentException(NEED_ONE_OR_TWO);
        }
        if (reGameNum == 1) {
            return true;
        }
        return false;
    }

    private static void validateReGameWord(String reGameWord) {
        validateLength(reGameWord, VALID_RE_GAME_NUM_LENGTH);
        validateAllDigit(reGameWord);
    }


    public static void validateWord(String playerNumWord) {
        validateLength(playerNumWord, VALID_NUM_LENGTH);
        validateAllDigit(playerNumWord);
        validateAllDifferent(playerNumWord);
    }

    private static void validateLength(String word, int validLength) throws IllegalArgumentException {
        if (word.length() != validLength) {
            throw new IllegalArgumentException(WRONG_NUM_LENGTH);
        }
    }

    private static void validateAllDigit(String word) {
        for (int i = 0; i < word.length(); i++) {
            validateDigitByIndex(word, i);
        }
    }

    private static void validateDigitByIndex(String word, int index) throws IllegalArgumentException {
        if (!Character.isDigit(word.charAt(index))) {
            throw new IllegalArgumentException(WRONG_TYPE);
        }
    }

    private static void validateAllDifferent(String word) throws IllegalArgumentException {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            set.add(word.charAt(i));
        }

        if (set.size() != word.length()) {
            throw new IllegalArgumentException(NEED_DIFFERENT_NUM);
        }
    }
}
