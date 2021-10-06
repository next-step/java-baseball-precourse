package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    @DisplayName("1부터 9까지 서로 다른 수로 이루어진 임의의 3자리 숫자를 생성할 수 있다.")
    @Test
    void create() {
        final Number randomNumber = RandomNumberGenerator.generate();
        assertThat(randomNumber).isNotNull();
    }
}
