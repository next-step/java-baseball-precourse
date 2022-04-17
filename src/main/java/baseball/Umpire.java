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
        if(input.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException(MESSAGE_ERROR_INPUT_3DIGIT);
        }

        LinkedHashSet<Integer> temp = new LinkedHashSet<>();
        for(int i = 0; i < input.length(); i++) {
            int tempValue = input.charAt(i) - '0';
            if(tempValue < 1 || tempValue > 9) {
                throw new IllegalArgumentException(MESSAGE_ERROR_INPUT_INVALID);
            }

            temp.add(tempValue);
        }

        if(temp.size() != INPUT_LENGTH) {
            throw new IllegalArgumentException(MESSAGE_ERROR_INPUT_DUPLICATE);
        }
    }

    public boolean getHint(LinkedHashSet<Integer> answer, String input) {
        int strikeCount = 0;
        int ballCount = 0;

        LinkedList<Integer> targetNumber = new LinkedList<>(answer);
        System.out.println(targetNumber);

        LinkedList<Integer> inputNumber = new LinkedList<>();
        for(int i = 0; i < input.length(); i++) {
            inputNumber.add(Integer.parseInt(input.substring(i, i + 1)));
        }
        System.out.println(inputNumber);

        for(int i = 0; i < input.length(); i++) {
            if(targetNumber.contains(inputNumber.get(i))) {
                if(targetNumber.get(i) == inputNumber.get(i)) {
                    strikeCount++;
                } else {
                    ballCount++;
                }
            }
        }

        if(strikeCount == 3) {
            System.out.println(strikeCount + HINT_STRIKE);
            System.out.println(MESSAGE_INFO_SUCCESS);
            return true;
        }

        String hint_strike = (strikeCount == 0) ? "" : (strikeCount + HINT_STRIKE);
        String hint_ball = (ballCount == 0) ? "" : (ballCount + HINT_BALL);
        if(strikeCount == 0 && ballCount == 0) {
            System.out.println(HINT_NOTHING);
        } else {
            System.out.println(hint_ball + hint_strike);
        }
        return false;
    }
}
