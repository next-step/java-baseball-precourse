package baseball;

import org.junit.jupiter.api.Test;

class RandomBaseBallGeneratorTest {

    @Test
    void GeneratorTest() {
        BallNumberGenerator ballNumberGenerator = new RandomBaseBallGenerator();
        for (int i = 0; i < 3; i++) {
            System.out.print(ballNumberGenerator.generate().get(i));
        }

    }
}