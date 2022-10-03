package baseball.utils;

import baseball.common.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {
    @Test
    @DisplayName("생성된 랜덤숫자 3자리 확인")
    void 생성된_랜덤숫자_3자리_확인() {
        RandomNumberGenerator resultNumbers = new RandomNumberGenerator();
        List<Integer> numbers = resultNumbers.getNumbers();
        assertThat(numbers).allMatch(number -> number.toString().matches("[1-9]"));
    }

    @DisplayName("생선된 3자리 숫자 중복 확인")
    @Test
    void 생성된_3자리_중복_확인() {
        RandomNumberGenerator resultNumbers = new RandomNumberGenerator();
        List<Integer> numbers = resultNumbers.getNumbers();
        Set<Integer> checkNumbers = new HashSet<>(numbers);
        assertThat(checkNumbers.size()).isEqualTo(numbers.size());
    }

    @DisplayName("생성된 숫자 3자리 확인")
    @Test
    void 생성된_숫자_3자리_확인() {
        RandomNumberGenerator resultNumbers = new RandomNumberGenerator();
        List<Integer> numbers = resultNumbers.getNumbers();
        assertThat(numbers.size()).isEqualTo(Constants.NUMBER_SIZE);
    }
}
