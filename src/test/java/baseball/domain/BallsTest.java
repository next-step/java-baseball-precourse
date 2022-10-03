package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BallsTest {

    @DisplayName("숫자가 3자리가 아니면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "19", "1359"})
    void numberSize(String numbersString) {
        List<Integer> numbers = stringToIntegerList(numbersString);

        assertThatThrownBy(() -> new Balls(numbers)).isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("같은 숫자를 입력하면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"113", "477", "666"})
    void numberDistinct(String numbersString) {
        List<Integer> numbers = stringToIntegerList(numbersString);

        assertThatThrownBy(() -> new Balls(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("공들의 숫자와 위치가 모두 다르면 결과는 낫싱이다")
    @ParameterizedTest
    @CsvSource(value = {"123:456", "987:564", "148:753"}, delimiter = ':')
    void nothing(String computerNumber, String userNumber) {
        Balls computerBalls = new Balls(stringToIntegerList(computerNumber));
        Balls userBalls = new Balls(stringToIntegerList(userNumber));

        assertThat(computerBalls.makeGameResult(userBalls).toString()).isEqualTo("낫싱");
    }


    @DisplayName("공들의 숫자와 위치가 모두 같으면 결과는 3스트라이크 이다")
    @ParameterizedTest
    @CsvSource(value = {"123:123", "987:987", "148:148", "753:753"}, delimiter = ':')
    void threeStrike(String computerNumber, String userNumber) {
        Balls computerBalls = new Balls(stringToIntegerList(computerNumber));
        Balls userBalls = new Balls(stringToIntegerList(userNumber));

        assertThat(computerBalls.makeGameResult(userBalls).toString()).isEqualTo("3스트라이크");
    }

    @DisplayName("공들의 숫자는 모두 같고 위치가 모두 다르면 결과는 3볼 이다")
    @ParameterizedTest
    @CsvSource(value = {"123:312", "987:798", "148:481", "753:375"}, delimiter = ':')
    void threeBall(String computerNumber, String userNumber) {
        Balls computerBalls = new Balls(stringToIntegerList(computerNumber));
        Balls userBalls = new Balls(stringToIntegerList(userNumber));

        assertThat(computerBalls.makeGameResult(userBalls).toString()).isEqualTo("3볼 ");
    }


    private List<Integer> stringToIntegerList(String numbersString) {
        String[] numberToken = numbersString.split("");
        List<Integer> numbers = new ArrayList<>();

        for (String number : numberToken) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }
}
