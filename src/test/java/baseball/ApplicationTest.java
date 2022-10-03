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
                    run("246", "135"
                            , "1", "597", "589"
                            , "2");
                    assertThat(output()).contains("낫싱", "3스트라이크"
                            , "1볼 1스트라이크", "3스트라이크"
                            , "게임 종료");
                },
                1, 3, 5
                , 5, 8, 9
        );
    }

    @Test
    void 게임종료_후_재시작2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "145", "671", "216", "713"
                            , "1", "547", "754"
                            , "1", "123"
                            , "2");
                    assertThat(output()).contains("1볼 1스트라이크", "1볼", "2볼", "1스트라이크", "3스트라이크"
                            , "3볼", "3스트라이크"
                            , "3스트라이크"
                            , "게임 종료");
                },
                7, 1, 3
                , 7, 5, 4
                , 1, 2, 3
        );
    }

    @Test
    void 게임종료_후_재시작3() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "145", "671", "216", "713"
                            , "1", "123", "456", "789", "629", "168", "529"
                            , "1", "123", "456"
                            , "2");
                    assertThat(output()).contains("1볼 1스트라이크", "1볼", "2볼", "1스트라이크", "3스트라이크"
                            , "1스트라이크", "1볼", "1스트라이크", "2스트라이크", "낫싱", "3스트라이크"
                            , "낫싱", "3스트라이크"
                            , "게임 종료");
                },
                7, 1, 3
                , 5, 2, 9
                , 4, 5, 6
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
}
