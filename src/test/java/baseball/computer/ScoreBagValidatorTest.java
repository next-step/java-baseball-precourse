package baseball.computer;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ScoreBagValidatorTest {

    ScoreBagValidator scoreBagValidator = new ScoreBagValidator();

    @Test
    void 세글자_초과() {
        assertThatThrownBy(() -> scoreBagValidator.valid("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정수형_체크() {
        assertThatThrownBy(() -> scoreBagValidator.valid("12a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복값_체크() {
        assertThatThrownBy(() -> scoreBagValidator.valid("122"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 논제로_체크() {
        assertThatThrownBy(() -> scoreBagValidator.valid("103"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
