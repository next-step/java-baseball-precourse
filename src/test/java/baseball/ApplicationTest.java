package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
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

    @Test
    void 랜덤숫자_테스트(){
        int randomNumber = Integer.parseInt(Application.getRandomNumber());
        assertThat(111<= randomNumber && randomNumber<=999).isTrue();
        System.out.println("randomNumber = " + randomNumber);
    }

    @Test
    void 입력값_테스트(){
        String testInput = "입력값 테스트";
        final byte[] buf = String.join("\n", testInput).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        String input = Application.getInput();
        assertThat(input).isEqualTo(testInput);
    }

    @Test
    void 입력값_길이_유효성_테스트(){
        String testInput = "1234";
        final byte[] buf = String.join("\n", testInput).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        assertThatThrownBy(()-> {
            Application.checkInput(testInput);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 유효하지 않습니다.");
    }

    @Test
    void 입력값_숫자_유효성_테스트(){
        String testInput = "가나다";
        final byte[] buf = String.join("\n", testInput).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        assertThatThrownBy(()-> {
            Application.checkInput(testInput);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 유효하지 않습니다.");
    }

    @Test
    void 삼진아웃_테스트(){
        Application.getStringResult("567","567");
        assertThat(output()).contains("3스트라이크");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
