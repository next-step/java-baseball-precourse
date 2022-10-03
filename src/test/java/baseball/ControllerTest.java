package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ControllerTest {

    private Controller controller = new Controller();

    @DisplayName("validateNumber 메서드 에러 확인")
    @Test
    void test1() {
        assertThatThrownBy(() -> controller.validateNumber("1")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> controller.validateNumber("1oz3")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> controller.validateNumber(" ")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 끝낼것인지 계속할 것인지 리턴값 확인")
    @Test
    void test2() {
        assertThat(controller.finishGame("2")).isEqualTo(true);
        assertThat(controller.finishGame("1")).isEqualTo(false);
    }

}
