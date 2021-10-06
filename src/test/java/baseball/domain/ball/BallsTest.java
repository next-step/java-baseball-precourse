package baseball.domain.ball;

import baseball.exception.BaseBallException.DuplicatedBallsException;
import baseball.exception.BaseBallException.InvalidBallsLength;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static baseball.constant.Rule.COUNT_OF_BALLS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("야구게임 숫자 모음 테스트")
public class BallsTest {

    @ParameterizedTest(name = "중복되지 않은 3자리 야구게임 숫자 모음 생성 테스트")
    @CsvSource({
            "1, 9, 7"
            , "2, 8, 1"
    })
    void 중복되지_않은_3자리_야구게임_숫자_모음_생성_테스트(int input1, int input2, int input3) {
        // given
        List<Integer> inputValues = Arrays.asList(input1, input2, input3);

        // when
        Balls balls = Balls.valueOf(inputValues);

        // then
        assertThat(balls.getSize()).isEqualTo(COUNT_OF_BALLS);
    }

    @ParameterizedTest(name = "중복 존재시 예외발생 테스트")
    @CsvSource({
            "9, 9, 7"
            , "2, 8, 2"
    })
    void 중복_존재시_예외발생_테스트(int input1, int input2, int input3) {
        // given
        List<Integer> inputValues = Arrays.asList(input1, input2, input3);

        // when + then
        assertThatThrownBy(() -> Balls.valueOf(inputValues)).isInstanceOf(DuplicatedBallsException.class);
    }

    @ParameterizedTest(name = "자리수 예외발생 테스트")
    @CsvSource({
            "1, 2, 3, 4"
    })
    void 자리수_예외발생_테스트(int input1, int input2, int input3, int input4) {
        // given
        List<Integer> inputValues1 = Arrays.asList(input1, input2);
        List<Integer> inputValues2 = Arrays.asList(input1, input2, input3, input4);
        List<Integer> inputValues3 = null;

        // when + then
        assertThatThrownBy(() -> Balls.valueOf(inputValues1)).isInstanceOf(InvalidBallsLength.class);
        assertThatThrownBy(() -> Balls.valueOf(inputValues2)).isInstanceOf(InvalidBallsLength.class);
        assertThatThrownBy(() -> Balls.valueOf(inputValues3)).isInstanceOf(InvalidBallsLength.class);
    }
}
