package baseball.number;

import baseball.score.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputNumberTest {
    @DisplayName("InputNumber 클래스를 정상적으로 생성한다.")
    @Test
    void construct() {
        String input = "1";
        InputNumber inputNumber = new InputNumber(0, input);
        assertThat(inputNumber).isEqualTo(new InputNumber(0, 1));
    }

    @DisplayName("index(위치)는 다르고, 숫자만 같은 것이 있으면 Ball을 반환한다.")
    @Test
    void matchBall() {
        TargetNumbers targetNumbers = new TargetNumbers("123");

        InputNumber inputNumber = new InputNumber(1, 1);
        Score score = inputNumber.match(targetNumbers);

        assertThat(score).isEqualTo(Score.BALL);
    }

    @DisplayName("index(위치)도 같고, 숫자도 같은 것이 있으면 Strike를 반환한다.")
    @Test
    void matchStrike() {
        TargetNumbers targetNumbers = new TargetNumbers("123");

        InputNumber inputNumber = new InputNumber(0, 1);
        Score score = inputNumber.match(targetNumbers);

        assertThat(score).isEqualTo(Score.STRIKE);
    }

    @DisplayName("index, 숫자 전부 다르면 Nothing을 출력한다.")
    @Test
    void matchNothing() {
        TargetNumbers targetNumbers = new TargetNumbers("123");

        InputNumber inputNumber = new InputNumber(0, 7);
        Score score = inputNumber.match(targetNumbers);

        assertThat(score).isEqualTo(Score.NOTHING);
    }
}
