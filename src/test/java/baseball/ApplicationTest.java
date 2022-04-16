package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
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

    @ParameterizedTest
    @ValueSource(strings = {"999", "120", "가나다", "31", "012", "910", "12!"})
    @DisplayName("사용자가 입력한 값이 유효성 체크를 통과하지 못하면 예외를 던진다")
    void When_Player_Invalidate_Throw_Exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RandomNumberByPlayer().validationCheck(input));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
