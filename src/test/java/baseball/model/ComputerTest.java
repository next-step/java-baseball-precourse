package baseball.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ComputerTest {

    @ParameterizedTest
    @CsvSource(value = {"3:3", "5:5", "8:8"}, delimiter = ':')
    void 컴퓨터가_생성한_숫자의_자리수는_예상한바와_맞음(int numberTotalLength, int expectedLength) {
        NumberControl numberControl = new NumberControl(numberTotalLength, 1, 9);
        Computer computer = new Computer(new DifferentRandomNumberGenerator(), numberControl);
        assertThat(computer.getNumber().size()).isEqualTo(expectedLength);
    }
}