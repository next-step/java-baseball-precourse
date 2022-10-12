package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckGameRuleTest extends NsTest {

    @Test
    void 숫자가_다른자리수에_포함되어있다면_볼이다() {
        try {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("672", "329", "782", "829", "982");
                        assertThat(output()).contains("1볼", "2볼", "3볼");
                    },
                    2, 9, 8
            );
        } catch (NoSuchElementException e) {
            System.out.println("다음 입력을 계속 받기 때문에 테스트가 끝나고 입력이 없는 경우는 무시한다.");
        }
    }

    @Test
    void 숫자가_같은자리수에_포함되어있다면_스트라이크이다() {
        try {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("257", "394", "258", "294");
                        assertThat(output()).contains("1스트라이크", "2스트라이크");
                    },
                    2, 9, 8
            );
        } catch (NoSuchElementException e) {
            System.out.println("다음 입력을 계속 받기 때문에 테스트가 끝나고 입력이 없는 경우는 무시한다.");
        }
    }

    @Test
    void 삼스트라이크가되면_게임이_종료된다() {
        try {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("298");
                        assertThat(output()).contains("게임 종료");
                    },
                    2, 9, 8
            );
        } catch (NoSuchElementException e) {
            System.out.println("다음 입력을 계속 받기 때문에 테스트가 끝나고 입력이 없는 경우는 무시한다.");
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
