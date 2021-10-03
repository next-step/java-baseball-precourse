package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumberTest {

    @DisplayName("1에서 9까지의 숫자를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9})
    void create(int value) {
        Number number = new Number(value);
        assertThat(number.getValue()).isEqualTo(value);
    }
}