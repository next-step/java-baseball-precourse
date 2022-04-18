package baseball.model;

import baseball.common.Constants;

import java.util.HashSet;
import java.util.Set;

public class InquirePlayer extends GameNumbers {

    public void thinkGoodInquireGameNumbers(String gameNumbers) {
        if (isValidGameNumbers(gameNumbers)) {
            this.setGameNumbers(gameNumbers);
        }
    }

    public boolean isValidGameNumbers(String gameNumbers) {
        if (!isDigitGameNumbers(gameNumbers) || !isSameGameNumbers(gameNumbers) || !isValidGameNumbersLength(gameNumbers)) {
            return false;
        }

        return true;
    }

    public boolean isDigitGameNumbers(String gameNumbers) {
        for (int i = 0; i < gameNumbers.length(); i++) {
            isDigit(gameNumbers, i);
        }
        return true;
    }

    public boolean isDigit(String gameNumbers, int index) {
        if (!Character.isDigit(gameNumbers.charAt(index))) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean isSameGameNumbers(String gameNumbers) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < gameNumbers.length(); i++) {
            set.add(gameNumbers.charAt(i));
        }
        if (set.size() != gameNumbers.length()) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean isValidGameNumbersLength(String gameNumbers) {
        if (gameNumbers.length() != Constants.USER_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public RequestHint inquireThinkedGameNumber() {
        RequestHint requestHint = new RequestHint();
        requestHint.setGameNumbers(this.getGameNumbers());

        return requestHint;
    }
}
