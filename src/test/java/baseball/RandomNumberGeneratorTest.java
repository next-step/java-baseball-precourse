package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomNumberGeneratorTest {

    private RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    public void setUp() {
        randomNumberGenerator = new RandomNumberGenerator(BaseBallGame.DEFAULT_LENGTH);
    }

    @Test
    public void 널_여부_체크() {
        String randomGenerated = randomNumberGenerator.generateNumbers();

        assertEquals(randomGenerated != null, true);
    }

    @Test
    public void 길이_3자리_체크() {
        String randomGenerated = randomNumberGenerator.generateNumbers();

        assertEquals(randomGenerated.length(), BaseBallGame.DEFAULT_LENGTH);
    }

    @Test
    public void 문자열_1에서9인지_체크() {
        String randomGenerated = randomNumberGenerator.generateNumbers();

        for (int i=0; i<randomGenerated.length(); i++) {
            //ASCII '0' = 48 이므로 '1'이 49이므로 49 - 48 = 1 숫자값으로 변환
            int number = randomGenerated.charAt(i)-'0';
            assertEquals((number >= 1 && number <= 9), true);
        }
    }

    @Test
    public void 랜덤_생성숫자_체크() {
        Set<String> numbers = new HashSet<>();

        for (int i=0; i<10; i++)
            numbers.add(randomNumberGenerator.generateNumbers());
        assertEquals(numbers.size(), 10);
    }
}
