package baseball;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Umpire {

    public static final String HINT_STRIKE = "스트라이크 ";
    public static final String HINT_BALL = "볼 ";
    public static final String HINT_NOTHING = "낫싱";

    public static final String MESSAGE_INFO_SUCCESS = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
    public static final String MESSAGE_ERROR_INPUT_3DIGIT = "3자리의 숫자만 입력가능합니다.";
    public static final String MESSAGE_ERROR_INPUT_INVALID = "숫자(1~9)가 아닌 문자가 입력되었습니다.";
    public static final String MESSAGE_ERROR_INPUT_DUPLICATE = "중복된 숫자가 입력되었습니다.";

    public static final int INPUT_LENGTH = 3;

    public void validate(String input) {
        checkLength(input.length(), MESSAGE_ERROR_INPUT_3DIGIT);

        LinkedHashSet<Integer> temp = new LinkedHashSet<>();
        for (int i = 0; i < input.length(); i++) {
            int tempValue = input.charAt(i) - '0';
            checkInvalid(tempValue < 1 || tempValue > 9, MESSAGE_ERROR_INPUT_INVALID);

            temp.add(tempValue);
        }

        checkDuplicate(temp.size() != INPUT_LENGTH, MESSAGE_ERROR_INPUT_DUPLICATE);
    }

    private void checkLength(int length, String messageErrorInput3digit) {
        checkInvalid(length != INPUT_LENGTH, messageErrorInput3digit);
    }

    private void checkInvalid(boolean b, String messageErrorInputInvalid) {
        checkDuplicate(b, messageErrorInputInvalid);
    }

    private void checkDuplicate(boolean b, String messageErrorInputDuplicate) {
        if (b) {
            throw new IllegalArgumentException(messageErrorInputDuplicate);
        }
    }

    public boolean getHint(LinkedHashSet<Integer> answer, String input) {
        int strikeCount = 0;
        int ballCount = 0;

        LinkedList<Integer> targetNumber = new LinkedList<>(answer);
        LinkedList<Integer> inputNumber = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            inputNumber.add(Integer.parseInt(input.substring(i, i + 1)));
        }

        for (int i = 0; i < input.length(); i++) {
            strikeCount = getStrikeCount(strikeCount, targetNumber, inputNumber, i);
            ballCount = getBallCount(ballCount, targetNumber, inputNumber, i);
        }

        return getDecision(strikeCount, ballCount);
    }

    private int getStrikeCount(int strikeCount, LinkedList<Integer> target, LinkedList<Integer> input, int index) {
        if (target.contains(input.get(index)) && target.get(index).equals(input.get(index))) {
            strikeCount++;
        }
        return strikeCount;
    }

    private int getBallCount(int ballCount, LinkedList<Integer> target, LinkedList<Integer> input, int index) {
        if (target.contains(input.get(index)) && !target.get(index).equals(input.get(index))) {
            ballCount++;
        }
        return ballCount;
    }

    private boolean getDecision(int strikeCount, int ballCount) {
        if (isWin(strikeCount)) {
            return true;
        }

        String hint_strike = (strikeCount == 0) ? "" : (strikeCount + HINT_STRIKE);
        String hint_ball = (ballCount == 0) ? "" : (ballCount + HINT_BALL);
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println(HINT_NOTHING);
        }
        if (strikeCount > 0 || ballCount > 0) {
            System.out.println(hint_ball + hint_strike);
        }
        return false;
    }

    private boolean isWin(int strikeCount) {
        if (strikeCount == 3) {
            System.out.println(strikeCount + HINT_STRIKE);
            System.out.println(MESSAGE_INFO_SUCCESS);
            return true;
        }
        return false;
    }
}
