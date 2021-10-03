package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class NumberTest {

    @DisplayName("1에서 9까지의 숫자를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9})
    void create(int value) {
        Number number = new Number(value);
        assertThat(number.getValue()).isEqualTo(value);
    }

    @DisplayName("1미만 9초과 숫자는 에러를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10, Integer.MAX_VALUE, Integer.MIN_VALUE})
    void create_error(int value) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new Number(value))
                .withMessage("[ERROR] 올바른 숫자를 입력해주세요.");
    }
}