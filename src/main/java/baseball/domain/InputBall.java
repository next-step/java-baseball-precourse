package baseball.domain;

import nextstep.utils.StringUtils;

import java.util.*;
import java.util.regex.Pattern;

public class InputBall {

    private static final int BALL_SIZE = 3;
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[1-9]*?");

    private List<Ball> balls = new LinkedList<>();

    public void clearInputBalls() {
        this.balls = new LinkedList<>();
    }

    public void of(String inputNumber) {
        clearInputBalls();
        validation(inputNumber);

        for (int i = 0; i < inputNumber.length(); i++) {
            int number = Character.getNumericValue(inputNumber.charAt(i));
            this.balls.add(new Ball (i, number));
        }
    }

    private void validation(String inputNumber) {
        validateNull(inputNumber);
        validateInputLength(inputNumber);
        validateNumberOtherThen(inputNumber);
        validateNumberDuplicate(inputNumber);
    }

    private void validateNull(String inputNumber) {
        if (StringUtils.isEmpty(inputNumber)) {
            throw new NullPointerException("숫자 입력은 필수입니다.");
        }
    }

    private void validateInputLength(String inputNumber) {
        if(inputNumber.length() > BALL_SIZE){
            throw new IllegalArgumentException( "입력한 값이 " + BALL_SIZE + " 길이를 초과하였습니다.");
        }
        if(inputNumber.length() < BALL_SIZE){
            throw new IllegalArgumentException( BALL_SIZE + " 길이의 입력은 필수입니다.");
        }
    }

    private void validateNumberDuplicate(String inputNumber) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < inputNumber.length(); i++) {
            set.add(Integer.valueOf(inputNumber.charAt(i)));
        }
        if (set.size() != inputNumber.length()) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    private void validateNumberOtherThen(String inputNumber) {
        boolean matches = NUMBER_PATTERN.matcher(inputNumber).matches();
        if (!matches) {
            throw new IllegalArgumentException("1 ~ 9 숫자 이외에 입력은 불가합니다.");
        }
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
