package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumbersTest {

    @Test
    @DisplayName("strikes, balls 계산")
    void matchWith() {
        Numbers computer = new Numbers(4, 2, 5);

        Result result = computer.matchWith(new Numbers(1, 2, 3));
        assertThat(result).isEqualTo(Result.of(1, 0));

        result = computer.matchWith(new Numbers(4, 5, 6));
        assertThat(result).isEqualTo(Result.of(1, 1));

        result = computer.matchWith(new Numbers(7, 8, 9));
        assertThat(result).isEqualTo(Result.of(0, 0));
    }
}