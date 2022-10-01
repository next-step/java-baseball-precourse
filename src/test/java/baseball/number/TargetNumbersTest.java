package baseball.number;

import baseball.number.strategy.ExtractRandomNumberByPickNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TargetNumbersTest {

    @DisplayName("TargetNumbers 객체를 생성한다.")
    @Test
    void construct() {
        TargetNumbers targetNumbers = new TargetNumbers(new ExtractRandomNumberByPickNumber());
        assertThat(targetNumbers.getTargetNumberList()).hasSize(3);
    }
}
