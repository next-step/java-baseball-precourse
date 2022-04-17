package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.game.GameRule;
import baseball.domain.generator.Generator;
import baseball.domain.generator.RandomNumbersGenerator;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumbersGeneratorTest {
    Generator numbersGenerator;
    GameRule gameRule;

    @BeforeEach
    void before() {
        gameRule = new GameRule(1, 9, 3);
        numbersGenerator = new RandomNumbersGenerator(gameRule);
    }

    @Test
    @DisplayName("생성한 숫자들의 size가 기대한 값과 같아야 한다.")
    void generateNumbers_PO1() {
        int expectSize = 3;
        List<Integer> numbers = numbersGenerator.generateNumbers();
        assertThat(numbers.size()).isEqualTo(expectSize);
    }

    @Test
    @DisplayName("각 원소가 중복되지 않는 숫자들을 생성한다.")
    void generateNumbers_PO2() {
        int expectSize = 3;
        List<Integer> numbers = numbersGenerator.generateNumbers();
        HashSet<Integer> numberSet = new HashSet<>(numbers);
        assertThat(numberSet.size()).isEqualTo(expectSize);
    }

    @Test
    @DisplayName("각 원소가 1~9 사이인 숫자들을 생성한다.")
    void generateNumbers_PO3() {
        List<Integer> numbers = numbersGenerator.generateNumbers();
        for (Integer num : numbers) {
            assertThat(num).isBetween(gameRule.MIN_NUM, gameRule.MAX_NUM);
        }
    }
}
