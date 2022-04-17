package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("BaseballNumber 클래스")
class BaseballNumbersTest {

    @Nested
    @DisplayName("생성자는")
    class Describe_constructor {
        BaseballNumbers subject(String str) {
            return new BaseballNumbers(str);
        }

        @Nested
        @DisplayName("숫자가 아닌 문자열이 주어지면")
        class Context_not_a_number_string {
            final String targetString = "12d";

            @Test
            @DisplayName("IllegalArgumentException 을 던진다.")
            void it_returns_BaseballNumber() {
                assertThatThrownBy(() -> subject(targetString))
                        .isExactlyInstanceOf(IllegalArgumentException.class);
            }
        }
    }
}