package baseball;

import baseball.vo.enumtype.Inclusive;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void 숫자_3개_매칭_테스트() {
        assertEquals(123, 123);
    }

    @Test
    void Randoms_pickNumberInRange_사용_테스트() {
        // give
        final int gameNumbersLen = 3;

        // when
        Set<Integer> gameNumberSet = getGameNumberSet();

        // then
        assertEquals(gameNumbersLen, gameNumberSet.size());
        System.out.println(gameNumberSet);
    }

    /**
     * 야구게임에서 컴퓨터가 가진 숫자 생성
     * @return gameNumberSet : Set<Integer>
     */
    public Set<Integer> getGameNumberSet() {
        final int gameNumbersLen = 3;
        final Set<Integer> gameNumberSet = new HashSet<>();

        do {
            gameNumberSet.add(Randoms.pickNumberInRange(Inclusive.START.getValue(), Inclusive.END.getValue()));
        } while (gameNumberSet.size() < gameNumbersLen);
        return gameNumberSet;
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
