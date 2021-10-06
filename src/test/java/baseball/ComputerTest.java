package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @Test
    void 세자리_값을_가진_Number_객체를_반환한다() {
        //given
        Computer computer = new Computer();

        //when
        Number result = computer.pick();

        //then
        assertThat(result.getValue()).hasSize(3);
    }
}