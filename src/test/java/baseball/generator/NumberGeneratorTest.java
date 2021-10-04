package baseball.generator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class NumberGeneratorTest {

    @Test
    @DisplayName("랜덤으로 3자리수 만들기")
    void makeThreeDigits() {
        //given && when
        final List<Integer> result = NumberGenerator.makeThreeDigits();
        //then
        assertThat(result.size()).isEqualTo(3);
    }
}