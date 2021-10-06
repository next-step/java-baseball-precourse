package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JudgmentTest {

    @DisplayName("컴퓨터가 가진 정답과 사용자의 읩력 값을 판단한 결과를 확인")
    @ParameterizedTest
    @CsvSource({"1,2,3,3,0","1,3,2,1,2","2,3,1,0,3","4,5,6,0,0"})
    void refereeCallSign(int number1, int number2, int number3, int strike, int ball) {
        Judgment judgment = new Judgment();
        BaseBall actual = judgment.compareNumber(Arrays.asList(1, 2, 3), Arrays.asList(number1, number2, number3));

        assertAll(
            () -> assertThat(actual.strike()).isEqualTo(strike),
            () -> assertThat(actual.ball()).isEqualTo(ball)
        );
    }
}
