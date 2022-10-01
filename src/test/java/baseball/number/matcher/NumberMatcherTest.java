package baseball.number.matcher;

import baseball.number.InputNumbers;
import baseball.number.TargetNumbers;
import baseball.score.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class NumberMatcherTest {

    @DisplayName("결과값과 입력한 값이 올바른지 확인한다.")
    @Test
    void match() {
        TargetNumbers targetNumbers = new TargetNumbers("123");
        InputNumbers inputNumbers = new InputNumbers("243");

        NumberMatcher numberMatcher = new NumberMatcher(targetNumbers, inputNumbers);
        List<Score> match = numberMatcher.match();

        assertAll(
                () -> assertThat(match.get(0)).isEqualTo(Score.BALL),
                () -> assertThat(match.get(1)).isEqualTo(Score.NOTHING),
                () -> assertThat(match.get(2)).isEqualTo(Score.STRIKE)
        );
    }

    @DisplayName("숫자 야구 결과값을 받는다.")
    @ParameterizedTest
    @CsvSource(value = {"243:1:1:1", "132:1:2:0", "123:3:0:0"}, delimiter = ':')
    void matchedResult(String input, int expectStrikeNumber, int expectedBallNumber, int expectedNothingNumber) {
        TargetNumbers targetNumbers = new TargetNumbers("123");
        InputNumbers inputNumbers = new InputNumbers(input);

        NumberMatcher numberMatcher = new NumberMatcher(targetNumbers, inputNumbers);
        Map<Score, Integer> scoreIntegerMap = numberMatcher.matchedResult();

        assertAll(
                () -> assertThat(scoreIntegerMap.get(Score.STRIKE)).isEqualTo(expectStrikeNumber),
                () -> assertThat(scoreIntegerMap.get(Score.BALL)).isEqualTo(expectedBallNumber),
                () -> assertThat(scoreIntegerMap.get(Score.NOTHING)).isEqualTo(expectedNothingNumber)
        );
    }
}
