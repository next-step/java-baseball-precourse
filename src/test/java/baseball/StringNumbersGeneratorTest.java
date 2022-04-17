package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.GameRule;
import baseball.domain.generator.Generator;
import baseball.domain.generator.StringNumbersGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringNumbersGeneratorTest {
    Generator numbersGenerator;

    @DisplayName("입력된 숫자 문자열의 size가 기대한 값과 같아야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"132", "352", "384"})
    void generateNumbers_PO1(String input) {
        int expectSize = 3;
        GameRule gameRule = new GameRule();
        numbersGenerator = new StringNumbersGenerator(input, gameRule);
        List<Integer> numbers = numbersGenerator.generateNumbers();
        assertThat(numbers.size()).isEqualTo(expectSize);
    }
}
