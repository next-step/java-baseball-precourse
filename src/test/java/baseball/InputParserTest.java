package baseball;

import java.util.ArrayList;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputParserTest {
    @ParameterizedTest
    @CsvSource(value = {"123,1,2,3", "245,2,4,5", "789,7,8,9", "765,7,6,5"}, delimiter = ',')
    void 유효한_문자열이_전달될_경우_문자열을_정수형_리스트로_변환한다(String input, int firstBallNum, int secondBallNum, int thirdBallNum) {
        ArrayList<Integer> parsed = new InputParser().parse(input);

        Assertions.assertThat(parsed.size()).isEqualTo(3);
        Assertions.assertThat(parsed).containsExactly(firstBallNum, secondBallNum, thirdBallNum);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5457", "796554645645", "-467562309", "abcj9hf", "abc", "99999"})
    void 유효하지_않은_문자열이_전달될_경우_빈_정수형_리스트를_반환한다(String input) {
        Assertions.assertThat(new InputParser().parse(input).size()).isEqualTo(0);
    }
}
