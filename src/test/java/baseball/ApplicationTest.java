package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    void 게임종료_후_재시작2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "123", "1", "319", "369", "2");
                    assertThat(output()).contains("1볼", "3스트라이크", "2스트라이크", "3스트라이크", "게임 종료");
                },
                1, 2, 3, 3, 6, 9
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
    @DisplayName("중복 숫자 입력 시 예외 발생")
    void 예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("게임 종료 후 1 또는 2 이외의 숫자 입력 시 예외 발생")
    void 예외_테스트3() {
        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> {
                    run("246", "123", "3");
                    assertThat(output()).contains("1볼", "3스트라이크");
                }).isInstanceOf(IllegalArgumentException.class),
                1, 2, 3
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
