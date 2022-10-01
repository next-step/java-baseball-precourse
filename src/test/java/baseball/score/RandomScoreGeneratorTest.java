package baseball.score;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomScoreGeneratorTest {
    
    @Test
    @DisplayName("랜덤 생성된 숫자 검증")
    void generateTest() {
        Pattern scorePattern = Pattern.compile("[1-9]{3}");
        
        ScoreGenerator scoreGenerator = new RandomScoreGenerator();
        String expectedScore = scoreGenerator.generate();
        
        assertTrue(scorePattern.matcher(expectedScore).matches());
    }
}
