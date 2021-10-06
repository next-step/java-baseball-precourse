package baseball.domain.ball;

import baseball.exception.BaseballException.DuplicatedBallsException;
import baseball.exception.BaseballException.InvalidBallsLength;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static baseball.constant.Rule.COUNT_OF_BALLS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("야구게임 숫자 모음 테스트")
public class BallsTest {

    @ParameterizedTest
    @CsvSource({
            "1, 9, 3"
    })
    void 중복되지_않은_3자리_야구게임_숫자_모음_생성_테스트(int input1, int input2, int input3) {
        // given
        List<Integer> numbers = Arrays.asList(1, 9, 3);

        // when
        Balls balls = Balls.valueOf(numbers);

        // then
        assertThat(balls.getSize()).isEqualTo(COUNT_OF_BALLS);
    }

    @ParameterizedTest
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

    @ParameterizedTest
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

    @Test
    void 스트라이크_비교_테스트() {
        // given
        Balls balls = Balls.valueOf(Arrays.asList(1, 9, 3));
        Balls threeStrike = Balls.valueOf(Arrays.asList(1, 9, 3));
        Balls oneStrike = Balls.valueOf(Arrays.asList(1, 7, 6));

        // when + then
        assertThat(balls.compare(threeStrike).getStrike()).isEqualTo(3);
        assertThat(balls.compare(oneStrike).getStrike()).isEqualTo(1);
    }

    @Test
    void 볼_비교_테스트() {
        // given
        Balls balls = Balls.valueOf(Arrays.asList(1, 9, 3));
        Balls oneBall = Balls.valueOf(Arrays.asList(6, 1, 7));
        Balls oneStrikeOneBall = Balls.valueOf(Arrays.asList(1, 7, 9));

        // when + then
        assertThat(balls.compare(oneBall).getBall()).isEqualTo(1);
        assertThat(balls.compare(oneStrikeOneBall).getStrike()).isEqualTo(1);
        assertThat(balls.compare(oneStrikeOneBall).getBall()).isEqualTo(1);
    }

    @Test
    void 낫싱_비교_테스트() {
        // given
        Balls balls = Balls.valueOf(Arrays.asList(1, 9, 3));
        Balls nothing = Balls.valueOf(Arrays.asList(7, 6, 8));

        // when + then
        assertThat(balls.compare(nothing).getStrike()).isEqualTo(0);
    }
}
