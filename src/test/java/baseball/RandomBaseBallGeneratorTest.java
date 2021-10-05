package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RandomBaseBallGeneratorTest {

    @Test
    void GeneratorDuplicateTest() {
        BallNumberGenerator ballNumberGenerator = new RandomBaseBallGenerator();

        assertThat(ballNumberGenerator.generate().size()).isEqualTo(ballNumberGenerator.generate().stream().distinct().count());
    }
}