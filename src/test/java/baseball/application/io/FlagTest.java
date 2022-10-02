package baseball.application.io;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FlagTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void 정적_팩토리_메서드_테스트(String number) {
        assertThatCode(() -> Flag.from(number))
            .doesNotThrowAnyException();
    }
}
