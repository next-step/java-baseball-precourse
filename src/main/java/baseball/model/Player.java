package baseball.model;

import baseball.domain.GameRule;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Player {
    private final ArrayList<Integer> playerNumbers;

    public Player(String userinput) throws IllegalArgumentException {
        validatePlayerNumber(userinput);

        playerNumbers = convertStringToArrayInteger(userinput);
    }

    private boolean validatePlayerNumber(String str) throws IllegalArgumentException {
        return validateInputLength(str)  && validateDuplicate(str) && validateNumberFormat(str);
    }

    private boolean validateInputLength(String str) throws IllegalArgumentException {
        if(str.length() == GameRule.MAX_LENGTH) {
            return true;
        }
        throw new IllegalArgumentException("3자리의 숫자만 입력할 수 있습니다.");
    }

    private boolean validateDuplicate(String str) throws IllegalArgumentException {
        Set<Character> checkStrSet = new HashSet<>();
        char[] charArr = str.toCharArray();

        for (char c : charArr) {
            checkStrSet.add(c);
        }

        if (checkStrSet.size() != GameRule.MAX_LENGTH) {
            throw new IllegalArgumentException("서로 다른 3가지 숫자를 입력해주세요.");
        }

        return true;
    }

    private boolean validateNumberFormat(String str) throws IllegalArgumentException {
        String regex = String.format("[%d-%d]{%d}", GameRule.MIN_VALUE, GameRule.MAX_VALUE, GameRule.MAX_LENGTH);

        if (str.matches(regex)) {
            return true;
        }
        throw new IllegalArgumentException("1~9 범위의 3자리 숫자만 입력할 수 있습니다.");
    }

    private ArrayList<Integer> convertStringToArrayInteger(String userStr) {
        ArrayList<Integer> userNumbers = new ArrayList<>();
        char[] userInputChars = userStr.toCharArray();

        for (char userInputChar : userInputChars) {
            userNumbers.add(Character.getNumericValue(userInputChar));
        }

        return userNumbers;
    }

    public ArrayList<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

}
