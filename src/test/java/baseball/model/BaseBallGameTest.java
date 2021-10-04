package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

@DisplayName("BaseBallGame: 정답을 갖고 있고 사용자의 입력값을 받아 비교 결과를 내려주는 게임 진행자 (Computer)")
public class BaseBallGameTest {

    @DisplayName("컴퓨터가 갖는 정답은 중복되지 않는 서로 다른 수로 이루어짐")
    @Test
    void validateDuplicateNumber() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new BaseBallGame(Arrays.asList(1, 1, 2)))
                .withMessageMatching("숫자 야구의 정답은 중복되지 않은 서로 다른 수로 이루어져야 합니다");
    }

    @DisplayName("사용자의 입력값 (String) 을 받아 스트라이크/볼 결과를 내려줌")
    @ParameterizedTest
    @CsvSource(value = {
            "123, 3, 0",
            "321, 1, 2",
            "456, 0, 0",
            "145, 1, 0",
            "312, 0, 3"
    })
    void testCompare(String input, int strikeCount, int ballCount) {
        BaseBallGame game = new BaseBallGame(Arrays.asList(1, 2, 3));
        CompareResult result = game.tryCompare(input);

        assertThat(result.getStrikeCount()).isEqualTo(strikeCount);
        assertThat(result.getBallCount()).isEqualTo(ballCount);
    }
}
