package baseball.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import baseball.vo.CompareResultVO;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    @ParameterizedTest(name = " 정답 725, 입력 ''{0}'' => ''{1}''스트라이크 ''{2}''볼")
    @CsvSource(value = {"751:1:1", "931:0:0", "725:3:0"}, delimiter = ':')
    void compareInputToAnswer(String inputNumber, int strikeCount, int ballCount) {

        List<Integer> answerNumberList = Arrays.asList(7, 2, 5);

        CompareResultVO compareResultVO = baseballGameService.compareInputToAnswer(inputNumber, answerNumberList);

        assertAll(
                () -> assertEquals(strikeCount, compareResultVO.getStrikeCount(), "스트라이크"),
                () -> assertEquals(ballCount, compareResultVO.getBallCount(), "볼")
        );
    }

    @DisplayName("사용자 야구숫자 입력에 대한 예외처리")
    @ParameterizedTest(name = "입력 ''{0}'' => ''{1}''")
    @CsvSource(value = {"test$t:숫자만 입력할 수 있습니다.", "12:3자리수가 아닙니다.", "103:0은 사용할 수 없습니다.", "779:중복된 숫자는 사용할 수 없습니다."}
            , delimiter = ':')
    void compareInputToAnswer_throw(String inputNumber, String expectedMessage) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> baseballGameService.compareInputToAnswer(inputNumber, Collections.emptyList()))
                .withMessage(expectedMessage);
    }
}