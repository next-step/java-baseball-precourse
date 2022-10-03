package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DigitTest {
    @Test
    void shouldReturnTrueIfEqual() {
        Digit actual = new Digit(1);
        Digit expected = new Digit(1);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldParseDigitCharToDigit() {
        Digit actual = Digit.parse('1');
        Digit expected = new Digit(1);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldThrowExceptionWithNonDigitChar() {
        assertThatThrownBy(() -> Digit.parse('a')).isInstanceOf(IllegalArgumentException.class);
    }
}
