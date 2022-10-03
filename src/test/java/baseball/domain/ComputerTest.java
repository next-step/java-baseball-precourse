package baseball.domain;

import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ComputerTest {

    @DisplayName("Computer의 balls와 비교해서 GameResult 를 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "4,5,6", "7,8,9"})
    void name(String numberString) {
        String[] numberToken = numberString.split(",");
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String number : numberToken) {
            numbers.add(Integer.parseInt(number));
        }
        Computer computer = new Computer(() -> numbers);
        Assertions.assertThat(computer.judgeResult(new Balls(numbers))).isInstanceOf(GameResult.class);
    }
}
