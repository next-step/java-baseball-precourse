package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RandomNumberGenerator 클래스")
public class RandomNumberGeneratorTest {

    @Nested
    @DisplayName("generate 메소드는")
    class Describe_generator {

        private RandomNumberGenerator subject(final int numberOfRandomNumber) {
            return new DefaultRandomNumberGenerator(numberOfRandomNumber);
        }

        @Nested
        @DisplayName("numberOfRandomNumber가 0이 주어지면")
        class Context_numberOfRandomNumber_zero {
            private final int numberOfRandomNumber = 0;

            @Test
            @DisplayName("빈 컬렉션을 리턴한다.")
            void it_returns_an_empty_set() {
                assertThat(subject(numberOfRandomNumber).generate()).isEmpty();
            }
        }

        @Nested
        @DisplayName("numberOfRandomNumber가 3이 주어지면")
        class Context_numberOfRandomNumber_three {
            private final int numberOfRandomNumber = 3;

            @Test
            @DisplayName("사이즈 3인 서로다른 수를 가지는 Integer<Integer>를 리턴한다.")
            void it_returns_an_empty_set() {
                final List<Integer> generatedNumber = subject(numberOfRandomNumber).generate();
                assertThat(generatedNumber).hasSize(3);
                assertThat(generatedNumber).map(HashSet::new).hasSize(numberOfRandomNumber);
            }
        }
    }
}
