package baseball.score;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class RandomScoreGeneratorTest {
    
    @Test
    @DisplayName("랜덤 생성된 숫자 검증")
    void generateTest() {
        ScoreGenerator scoreGenerator = new RandomScoreGenerator();
        ScoreBoard expectedScore = scoreGenerator.generate();
    
        assertAll(
                () -> assertEquals(3, expectedScore.size()),
                () -> assertFalse(expectedScore.contains(0))
        );
    }
}
