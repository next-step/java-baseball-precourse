package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallNumberTest {

    @Test
    public void create_different_number_test() {
        BaseBallNumber baseBallNumber = new BaseBallNumber(123);
        assertThat(baseBallNumber.isCorrectAnswer(123)).isEqualTo(true);
    }
}
