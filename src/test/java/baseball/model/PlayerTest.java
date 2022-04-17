package baseball.model;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class PlayerTest extends NsTest {

    @ParameterizedTest
    @ValueSource(strings = {"999", "120", "가나다", "31", "012", "910", "12!", "5423"})
    @DisplayName("사용자 입력 값이 유효성 체크를 통과하지 못하면 예외를 던진다")
    void When_Player_Invalidate_Throw_Exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player().validationCheck(input));
    }

    @Test
    @DisplayName("사용자 입력값 중 중복되는 값이 있으면 예외를 던진다.")
    void When_Input_Duplicated_Throw_Exception() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("333"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("323"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("141"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}