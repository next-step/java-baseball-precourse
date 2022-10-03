package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 문자입력_테스트() {
        String inputStr = "asd";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(inputStr))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("숫자가 아닌 값이 입력되었습니다. -> " + inputStr)
        );
    }

    @Test
    void 숫자0_입력_테스트() {
        String inputStr = "012";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(inputStr))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("0은 입력할 수 없습니다. -> " + inputStr)
        );
    }

    @Test
    void 입력범위_초과_테스트() {
        String inputStr = "1234";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(inputStr))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력된 문자의 길이가 잘못되었습니다. -> " + inputStr)
        );
    }

    @Test
    void 정상종료_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }
}
