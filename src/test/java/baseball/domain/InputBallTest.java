package baseball.domain;

import baseball.view.InputView;
import baseball.view.OutputView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputBallTest {

    InputBall inputBall;

    public InputBallTest() {
        this.inputBall = new InputBall();
    }

    @BeforeEach
    void setInputBall() {
        inputBall.of("123");
    }

    @Test
    @DisplayName("사용자입력 숫자 결과 확인")
    public void 입력값_확인() throws Exception{
        List<Ball> balls = inputBall.getBalls();
        for (int i = 0; i < balls.size(); i++) {
            assertThat(balls.get(i).getNumber() == i + 1);
            assertThat(balls.get(i).getSeq() == i);
        }
    }

    @Test
    @DisplayName("사용자입력 예외 케이스 검증")
    public void 입력값_예외검증() throws Exception{
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputBall.of("1234");
        }).withMessage("입력한 값이 3 길이를 초과하였습니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputBall.of("122");
        }).withMessage("중복된 숫자가 존재합니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputBall.of("091");
        }).withMessage("1 ~ 9 숫자 이외에 입력은 불가합니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputBall.of("09A");
        }).withMessage("1 ~ 9 숫자 이외에 입력은 불가합니다.");

        assertThatNullPointerException().isThrownBy(() -> {
            inputBall.of("");
        }).withMessage("숫자 입력은 필수입니다.");

    }

}