package baseball.domain;

import baseball.constant.Const;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ComputerTest {

    @Test
    @DisplayName("랜덤 숫자 생성 테스트")
    void generate_random_numbers_test() {
        Computer computer = new Computer();
        computer.initNumber();
        assertThat(computer.getNumbers().size()).isEqualTo(Const.GENERATE_NUMBER_SIZE);
    }

    @Test
    @DisplayName("생성한 랜덤 숫자 중복 여부 테스트")
    void generate_random_numbers_duplicate_test() {
        Computer computer = new Computer();
        computer.initNumber();
        assertThat(computer.getNumbers().get(0)).isNotEqualTo(computer.getNumbers().get(1));
        assertThat(computer.getNumbers().get(1)).isNotEqualTo(computer.getNumbers().get(2));
        assertThat(computer.getNumbers().get(0)).isNotEqualTo(computer.getNumbers().get(2));
    }

}
