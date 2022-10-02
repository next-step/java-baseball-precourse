package baseball.model;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static baseball.common.ConstRegex.ONE_TO_NINE;
import static baseball.common.ConstValue.INPUT_LENGTH;

public class User extends BallList {

    public UserResult userResult;

    public User(String numbers) {
        addBall(convertToListInteger(numbers));
        this.userResult = new UserResult();
    }

    private List<Integer> convertToListInteger(String numbers) {
        isValidUserBall(numbers);

        Set<Integer> userBall = new LinkedHashSet<>();
        for (String number : numbers.split("")) {
            userBall.add(Integer.parseInt(number));
        }
        isDuplicatedUserBall(userBall);
        return new ArrayList<>(userBall);
    }

    private void isValidUserBall(String input) {
        // 숫자 체크 (1-9)
        if (!input.matches(ONE_TO_NINE)) {
            throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
        }
        if (input.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException("입력한 숫자의 길이가 올바르지 않습니다.");
        }
    }

    private void isDuplicatedUserBall(Set<Integer> integerSet) {
        if (integerSet.size() != 3) {
            throw new IllegalArgumentException("중복된 숫자가 있어 프로그램을 종료합니다.");
        }
    }

    public String score(List<Ball> answer) {
        for (int i = 0; i < answer.size(); i++) {
            userResult.setScore(answer, this.ballList.get(i), i);
        }
        return userResult.getResult();
    }
}
