package baseball.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValueCallTest {
    ValueCall valueCall = new ValueCall();

    @ParameterizedTest
    @CsvSource(value = {"145:1", "124:2", "123:3"}, delimiter = ':')
    void 스트라이크_검증_테스트(String inputValue, String resultCount) {
        Set<Integer> testValue = new LinkedHashSet<>();
        for (char character : inputValue.toCharArray()) {
            testValue.add(Integer.parseInt(String.valueOf(character)));
        }

        valueCall.strikeCall(testValue, "123");
        assertEquals(resultCount, String.valueOf(valueCall.getStrikeCount()));
    }

    @ParameterizedTest
    @CsvSource(value = {"451:1", "214:2", "231:3"}, delimiter = ':')
    void 볼_검증_테스트(String inputValue, String resultCount) {
        Set<Integer> testValue = new LinkedHashSet<>();
        for (char character : inputValue.toCharArray()) {
            testValue.add(Integer.parseInt(String.valueOf(character)));
        }

        valueCall.ballCall(testValue, "123");
        assertEquals(resultCount, String.valueOf(valueCall.getBallCount()));
    }
}
