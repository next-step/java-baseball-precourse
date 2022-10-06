package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    @DisplayName("사용자가 선택한 숫자 확인")
    void retrieveInputNumber() {
        // given
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        // when
        Player player = new Player(numbers);
        // then
        assertThat(numbers.get(0)).isEqualTo(1);
        assertThat(numbers.get(1)).isEqualTo(2);
        assertThat(numbers.get(2)).isEqualTo(3);
    }

    @Test
    @DisplayName("입력한 문자열 Integer로 변환하여 List로 처리 확인")
    void couldStringToIntegerList() {
        // given
        String numStr = "123";
        Player player = new Player();

        // when
        List<Integer> numbers = player.changeStringToIntegerList(numStr);
        // then
        assertThat(numbers.get(0)).isEqualTo(1);
        assertThat(numbers.get(1)).isEqualTo(2);
        assertThat(numbers.get(2)).isEqualTo(3);
    }
}
