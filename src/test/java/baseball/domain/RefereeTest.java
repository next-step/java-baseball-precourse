package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RefereeTest {
    private static final List<Integer> COM_NUMBERS = Arrays.asList(1, 2, 3);
    private Referee referee;

    @BeforeEach
    void setUp() {
        referee = new Referee();
    }

    @DisplayName("비교 테스트")
    @ParameterizedTest
    @CsvSource({"1,2,3,0,3", "3,1,2,3,0", "1,3,2,2,1", "7,8,9,0,0"})
    public void atBat(int number1, int number2, int number3, int ball, int strike) {
        Count count = new Count();
        referee.atBat(COM_NUMBERS, Arrays.asList(number1, number2, number3), count);
        assertThat(count.getBall()).isEqualTo(ball);
        assertThat(count.getStrike()).isEqualTo(strike);
    }
}