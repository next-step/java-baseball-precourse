package baseball.model;

import static org.junit.jupiter.api.Assertions.*;

import baseball.vo.CompareResultVO;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameServiceTest {

    private final BaseballGameService baseballGameService = new BaseballGameService();

    @DisplayName("숫자 야구게임에 대한 정답을 생성(임의의 수)")
    @Test
    void createAnswer() {
        baseballGameService.createAnswer();
        List<Integer> answerNumberList = baseballGameService.getAnswerNumberList();

        assertAll(
                () -> assertEquals(3, answerNumberList.size(), "정답은 3자리 숫자여야한다."),
                () -> assertFalse(answerNumberList.contains(0), "정답 숫자에는 0을 포함하지 않는다."),
                () -> assertEquals(3, new HashSet<>(answerNumberList).size(),
                        "정답 숫자들은 중복을 허용하지 않는다.")
        );
    }

    @DisplayName("사용자 야구숫자 입력과 정답을 비교")
    @Test
    void compareInputToAnswer() {

        List<Integer> answerNumberList = Arrays.asList(7, 2, 5);
        String inputNumber = "751";

        CompareResultVO compareResultVO = baseballGameService.compareInputToAnswer(inputNumber, answerNumberList);

        assertAll("결과는 1스트라이크 1볼이다.",
                () -> assertEquals(1, compareResultVO.getBallCount()),
                () -> assertEquals(1, compareResultVO.getStrikeCount())
        );

        inputNumber = "931";

        CompareResultVO compareResultVO1 = baseballGameService.compareInputToAnswer(inputNumber, answerNumberList);

        assertAll(
                "결과는 0스트라이크 0볼이다.",
                () -> assertEquals(0, compareResultVO1.getBallCount()),
                () -> assertEquals(0, compareResultVO1.getStrikeCount())
        );

        inputNumber = "725";

        CompareResultVO compareResultVO2 = baseballGameService.compareInputToAnswer(inputNumber, answerNumberList);

        assertAll("결과는 3스트라이크 0볼이다.",
                () -> assertEquals(0, compareResultVO2.getBallCount()),
                () -> assertEquals(3, compareResultVO2.getStrikeCount())
        );
    }

    @DisplayName("사용자 야구숫자 입력에 대한 예외처리")
    @Test
    void compareInputToAnswer_throw() {

        List<Integer> answerNumberList = Arrays.asList(3, 6, 9);

        assertAll(() -> assertThrows(IllegalArgumentException.class,
                () -> baseballGameService.compareInputToAnswer("tes$t", answerNumberList),
                "숫자가 아니면 IllegalArgumentException이 발생한다."),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> baseballGameService.compareInputToAnswer("12", answerNumberList),
                        "3자리수가 아니면 IllegalArgumentException이 발생한다."),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> baseballGameService.compareInputToAnswer("103", answerNumberList),
                        "입력에 0이 포함되면 IllegalArgumentException이 발생한다."),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> baseballGameService.compareInputToAnswer("779", answerNumberList),
                        "입력에 중복된 숫자가 포함되면 IllegalArgumentException이 발생한다.")
        );
    }
}