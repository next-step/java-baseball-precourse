package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NumbersTest {

    @DisplayName("서로 다른 3자리 숫자를 가진다.")
    @Test
    void create() {
        Numbers numbers = new Numbers("123");
        assertThat(numbers.getNumbers())
                .containsExactly(new Number(1), new Number(2), new Number(3));
    }

    @DisplayName("중복 숫자가 있으면 에러를 발생시킨다.")
    @Test
    void create_duplicate() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new Numbers("111"))
                .withMessage("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
    }

    @DisplayName("3자리가 아닌 경우 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"12","1234"})
    void create_three_digit(String value) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new Numbers(value))
                .withMessage("[ERROR] 3자리 숫자만 입력가능합니다.");
    }
}