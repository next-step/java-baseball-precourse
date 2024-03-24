package model;

import model.GameNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class GameNumberGeneratorTest {

    @DisplayName("3자리의 수를 생성한다.")
    @Test
    void generate_3Digits() {
        // given, when
        int num = GameNumberGenerator.generate();

        // then
        assertThat(num).isBetween(100, 999);
    }

    @DisplayName("서로 다른 수를 생성한다.")
    @Test
    void generate_allDifferentDigits() {
        // given
        int num = GameNumberGenerator.generate();

        // when
        int total = 0;
        Set<Integer> nums = new HashSet<>();
        while (num > 0) {
            nums.add(num % 10);
            total += 1;
            num = num / 10;
        }

        // then
        assertThat(total).isEqualTo(nums.size());
    }

    @DisplayName("모든 자릿수에 0이 없다. (모든 자릿수는 1에서 9 사이의 숫자이다.)")
    @Test
    void generate_noZero() {
        // given
        int num = GameNumberGenerator.generate();

        // when
        Set<Integer> nums = new HashSet<>();
        while (num > 0) {
            nums.add(num % 10);
            num = num / 10;
        }

        // then
        assertThat(nums).doesNotContain(0);
    }
}