package baseball.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameServiceTest {

    private final BaseballGameService baseballGameService = new BaseballGameService();

    @DisplayName("숫자 야구게임에 대한 정답을 생성(임의의 수)")
    @Test
    void initAnswer() {
        baseballGameService.initAnswer();
        int answer = baseballGameService.getAnswer();
        int nums = answer;
        List<Integer> numberList = new ArrayList<>();

        while (nums > 0) {
            numberList.add(nums % 10);
            nums = nums / 10;
        }

        assertAll(
                () -> assertTrue(answer >= 100 && answer < 1000, "정답은 3자리 숫자여야한다."),
                () -> assertFalse(numberList.contains(0), "정답 숫자에는 0을 포함하지 않는다.")
        );
    }
}