package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BaseBallGameTest {

    @DisplayName("컴퓨터 공과 일치하지 않을 경우 상태는 RUNNING 이다.")
    @ParameterizedTest
    @CsvSource(value = {"123:321", "456:457", "789:189"}, delimiter = ':')
    void running(String computerNum, String playerNum) {
        List<Integer> computerNumbers = stringToIntegerList(computerNum);
        List<Integer> playerNumbers = stringToIntegerList(playerNum);

        BaseBallGame baseBallGame = new BaseBallGame(() -> computerNumbers);
        baseBallGame.playOnce(playerNumbers);
        assertThat(baseBallGame.isGameEnd()).isFalse();
    }

    @DisplayName("컴퓨터 공과 일치할 경우 게임의 상태는 FINISH 가 된다.")
    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789", "513", "432"})
    void finish(String stringNum) {
        List<Integer> numbers = stringToIntegerList(stringNum);

        BaseBallGame baseBallGame = new BaseBallGame(() -> numbers);
        baseBallGame.playOnce(numbers);
        assertThat(baseBallGame.isGameEnd()).isTrue();
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
