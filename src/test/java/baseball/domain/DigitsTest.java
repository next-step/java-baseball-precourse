package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DigitsTest {
    @Test
    void digitsMoreOrLessThanThreeThrowException() {
        assertThatThrownBy(() -> new Digits(new Digit[]{new Digit(1), new Digit(2), new Digit(3), new Digit(4)})).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Digits(new Digit[]{new Digit(1), new Digit(2)})).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void buildIntegersToDigits() {
        Digits actual = Digits.build(1, 2, 3);
        Digits expected = new Digits(new Digit[]{new Digit(1), new Digit(2), new Digit(3)});
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void parseStringToDigits() {
        Digits actual = Digits.parse("123");
        Digits expected = Digits.build(1, 2, 3);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void parseWrongStringGetsException() {
        assertThatThrownBy(() -> Digits.parse("1234")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Digits.parse("12a")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldReturnThreeBall() {
        Digits digits = Digits.build(1, 2, 3);
        Digits inputDigits = Digits.build(3, 1, 2);
        assertThat(digits.match(inputDigits)).isEqualTo(new Score(3, 0));
    }

    @Test
    void shouldReturnThreeStrike() {
        Digits digits = Digits.build(1, 2, 3);
        Digits inputDigits = Digits.build(1, 2, 3);
        assertThat(digits.match(inputDigits)).isEqualTo(new Score(0, 3));
    }

    @Test
    void shouldReturnOneStrikeOneBall() {
        Digits digits = Digits.build(1, 2, 3);
        Digits inputDigits = Digits.build(4, 1, 3);
        assertThat(digits.match(inputDigits)).isEqualTo(new Score(1, 1));
    }
}
