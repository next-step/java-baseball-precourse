package baseball.domains;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {

    @Test
    @DisplayName("Swing 메소드를 호출하면 랜덤 세자리 숫자형 문자열을 생성한다.")
    void Should_GenerateRandomNumericString_When_CallSwing() {
        // given
        Computer computer = new Computer();
        // when
        computer.play();
        // then
        assertThat(computer.getAimPositions().length()).isEqualTo(3);
    }

}
