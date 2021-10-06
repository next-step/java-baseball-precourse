package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RefereeTest {

    @DisplayName("심판의 콜사인을 테스트")
    @ParameterizedTest
    @CsvSource({"3,0,3스트라이크","1,2,1스트라이크 2볼","0,0,낫싱","0,3,3볼"})
    void refereeCallSign(int strike, int ball, String expected) {
        BaseBall result = new BaseBall(strike, ball);
        String actual = Referee.callSign(result);

        assertThat(actual).isEqualTo(expected);
    }
}

