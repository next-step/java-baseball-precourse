package baseball.model;

import java.util.HashSet;
import java.util.Set;

public class BaseballCount {
    private final String ballCount;
    public final static int PLAY_NUMBER_LENGTH = 3;

    public BaseballCount(String ballCount) {
        this.ballCount = ballCount;
        inputNumberValidationCheck();
    }

    public String getBallCount() {
        return ballCount;
    }

    public void inputNumberValidationCheck() {
        if (ballCount.length() != PLAY_NUMBER_LENGTH) {
            throw new IllegalArgumentException("playNumber length error");
        }
        if (!isNumberFormat()) {
            throw new IllegalArgumentException("playNumber format error");
        }
        if (isDuplicateNumber()) {
            throw new IllegalArgumentException("playNumber is duplicate");
        }
    }

    private boolean isNumberFormat() {
        boolean result = true;
        for (int i = 0; i < ballCount.length(); i++) {
            result = result && checkNumberRange(ballCount.charAt(i) - '0');
        }
        return result;
    }

    private boolean checkNumberRange(int num) {
        return num > 0 && num < 10;
    }

    public boolean isDuplicateNumber() {
        Set<Character> setForDuplicateCheck = new HashSet<>();
        for (int i = 0; i < ballCount.length(); i++) {
            setForDuplicateCheck.add(ballCount.charAt(i));
        }

        return setForDuplicateCheck.size() != ballCount.length();
    }
}
