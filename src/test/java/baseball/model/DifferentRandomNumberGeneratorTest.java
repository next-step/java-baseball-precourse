package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DifferentRandomNumberGeneratorTest {

    @ParameterizedTest
    @CsvSource(value = {"3:1:9", "4:2:7"}, delimiter = ':')
    void 생성된_숫자의_각_자리수는_startInclusize_보다_크거나_같음(int numberTotalLength, int startInclusive, int endInclusive) {
        NumberControl numberControl = new NumberControl(numberTotalLength, startInclusive, endInclusive);
        NumberGenerator numberGenerator = new DifferentRandomNumberGenerator();
        Map<Integer, Integer> generateNumber = numberGenerator.generateNumber(numberControl);

        assertThat(generateNumber.keySet())
                .allMatch(number -> number.compareTo(startInclusive) >= 0);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:2:9", "4:3:8"}, delimiter = ':')
    void 생성된_숫자의_각_자리수는_endInclusive_보다_작거나_같음(int numberTotalLength, int startInclusive, int endInclusive) {
        NumberControl numberControl = new NumberControl(numberTotalLength, startInclusive, endInclusive);
        NumberGenerator numberGenerator = new DifferentRandomNumberGenerator();
        Map<Integer, Integer> generateNumber = numberGenerator.generateNumber(numberControl);

        assertThat(generateNumber.keySet())
                .allMatch(number -> number.compareTo(endInclusive) <= 0);
    }
}