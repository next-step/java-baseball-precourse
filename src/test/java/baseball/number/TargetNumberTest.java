package baseball.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class TargetNumberTest {

    @DisplayName("TargetNumber 클래스를 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void construct(String numberString) {
        TargetNumber targetNumber = new TargetNumber(numberString);
        assertThat(targetNumber).isEqualTo(new TargetNumber(numberString));
    }
}
