package baseball.model;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    void 자릿수와_위치가_동일할경우_스트라이크를_반환한다() {
        NumberGenerator numberGenerator = new GivenNumberGenerator(Arrays.asList(1, 2, 3));
        Computer computer = new Computer(numberGenerator);
        Assertions.assertThat(computer.judge(0, 1))
                .isEqualTo(JudgeResult.STRIKE);
    }

    @Test
    void 위치는_다르나_숫자가_존재할경우_볼을_반환한다() {
        NumberGenerator numberGenerator = new GivenNumberGenerator(Arrays.asList(1, 2, 3));
        Computer computer = new Computer(numberGenerator);
        Assertions.assertThat(computer.judge(1, 1))
                .isEqualTo(JudgeResult.BALL);
    }

    @Test
    void 위치가_다르며_숫자가_포함되지_않는경우_빈값을_반환한다() {
        NumberGenerator numberGenerator = new GivenNumberGenerator(Arrays.asList(1, 2, 3));
        Computer computer = new Computer(numberGenerator);
        Assertions.assertThat(computer.judge(1, 4))
                .isEqualTo(JudgeResult.NONE);
    }

}