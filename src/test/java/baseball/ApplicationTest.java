package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    @DisplayName("게임종료_후_재시작")
    void restartGameTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    @DisplayName("예외_테스트")
    void exceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    List<Integer> numbers = null;

    @BeforeEach
    void beforeEach() {
        numbers = Arrays.asList(1, 2, 3, 4, 5);
    }

    @Test
    @DisplayName("랜덤 숫자 생성 테스트(리스트)")
    void pickNumberInListTest() {
        int randomNumberInList = Randoms.pickNumberInList(numbers);
        assertThat(randomNumberInList).isIn(numbers);
    }

    @Test
    @DisplayName("랜덤 숫자 생성 테스트(범위)")
    void pickNumberInRangeTest() {
        int randomNumberInRange = Randoms.pickNumberInRange(1, 5);
        assertThat(randomNumberInRange).isIn(numbers);
    }

    @Test
    @DisplayName("랜덤 숫자 생성 테스트(유니크)")
    void pickUniqueNumbersInRangeTest() {
        int size = 3;
        List<Integer> randomUniqueNumberInRange = Randoms.pickUniqueNumbersInRange(1,5, size);
        assertThat(randomUniqueNumberInRange.size()).isEqualTo(size);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
