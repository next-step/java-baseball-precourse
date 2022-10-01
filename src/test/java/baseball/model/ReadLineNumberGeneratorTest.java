package baseball.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Map;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ReadLineNumberGeneratorTest {

    @ParameterizedTest
    @CsvSource(value = {"1223:4:1:8", "15312:5:1:6"}, delimiter = ':')
    void 입력한_숫자에_중복된_값이_있으면_에러_발생(String readNumber, int numberTotalLength, int startInclusive, int endInclusive) {
        NumberControl numberControl = new NumberControl(numberTotalLength, startInclusive, endInclusive);
        NumberGenerator numberGenerator = new ReadLineNumberGenerator(readNumber);
        assertThatThrownBy(() -> {
            numberGenerator.generateNumber(numberControl);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("중복된 숫자는 허용하지 않습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"123:3:2:8", "5312:4:2:6", "123!$:5:1:9"}, delimiter = ':')
    void 입력한_숫자_각각에는_startInclusive보다_작은_값이_들어갈_수_없음(String readNumber, int numberTotalLength, int startInclusive, int endInclusive) {
        NumberControl numberControl = new NumberControl(numberTotalLength, startInclusive, endInclusive);
        NumberGenerator numberGenerator = new ReadLineNumberGenerator(readNumber);
        assertThatThrownBy(() -> {
            numberGenerator.generateNumber(numberControl);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("각 자리의 숫자는 " + startInclusive + "보다 작을 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"529:3:2:5", "53812:5:1:6", "123ae:5:1:9"}, delimiter = ':')
    void 입력한_숫자_각각에는_endInclusive보다_큰_값이_들어갈_수_없음(String readNumber, int numberTotalLength, int startInclusive, int endInclusive) {
        NumberControl numberControl = new NumberControl(numberTotalLength, startInclusive, endInclusive);
        NumberGenerator numberGenerator = new ReadLineNumberGenerator(readNumber);
        assertThatThrownBy(() -> {
            numberGenerator.generateNumber(numberControl);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("각 자리의 숫자는 " + endInclusive + "보다 클 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"5291:4:1:9", "43812:5:1:9"}, delimiter = ':')
    void generateNumber_정상_생성_테스트(String readNumber, int numberTotalLength, int startInclusive, int endInclusive) {
        NumberControl numberControl = new NumberControl(numberTotalLength, startInclusive, endInclusive);
        NumberGenerator numberGenerator = new ReadLineNumberGenerator(readNumber);
        Map<Integer, Integer> generateNumber = numberGenerator.generateNumber(numberControl);
        assertThat(generateNumber.keySet())
                .allMatch(number -> readNumber.contains(number.toString()));

    }
}