package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @Test
    @DisplayName("컴퓨터가 세 개의 숫자를 가진 배열을 생성한다.")
    void generateThreeNumberTest() {
        // given
        Computer computer = new Computer();
        // when
        List<Integer> numbers = computer.getNumbers();
        // then
        assertThat(numbers).hasSize(3);
    }


}