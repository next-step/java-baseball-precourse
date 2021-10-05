package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @DisplayName("3자리의 중복되지 않는 랜덤한 숫자를 생성한다.")
    @Test
    void create() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        String value = generator.getValue();
        assertThat(value.length()).isEqualTo(3);
    }
}