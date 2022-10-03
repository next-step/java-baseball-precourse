package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    private Ball ball;

    @BeforeEach
    void setUp() {
        ball = new Ball();
    }

    @Test
    @DisplayName("서로 다른 임의의 수 3개 선택")
    void generateNotDuplicatedNumber() {
        int ballNumber = ball.generateBallNumber();
        String strNum = Integer.toString(ballNumber);
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < strNum.length(); i++) {
            set.add(strNum.charAt(i) - '0');
        }

        assertThat(set.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("유효한 볼인지 확인 - 각 자릿수값마다 중복없는 세자리수 정수")
    @ValueSource(ints = {123, 274})
    void validateBallNumber(int ballNumber) {
        assertThat(ball.validateBallNumber(ballNumber)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("유효하지않은 정수 볼 테스트")
    @ValueSource(ints = {1234, 223, 12, 0, 102})
    void notValidateBallNumber(int ballNumber) {
        assertThat(ball.validateBallNumber(ballNumber)).isFalse();
    }
}
