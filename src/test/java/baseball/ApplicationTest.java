package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import baseball.vo.RuleVo;
import baseball.vo.enumtype.Inclusive;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;

class ApplicationTest extends NsTest {
    //    private OutputStream captor;
    //
    //    public String output() {
    //        return captor.toString().trim();
    //    }


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
        final int gameNumbersLen = RuleVo.getGameNumbersLen();

        // when
        List<Integer> gameNumberList = getGameNumberList();

        // then
        assertEquals(gameNumbersLen, gameNumberList.size());
        System.out.println(gameNumberList);
    }

    /**
     * 야구게임에서 컴퓨터가 가진 숫자 생성
     * @return gameNumberList : List<Integer>
     */
    public List<Integer> getGameNumberList() {
        final Set<Integer> gameNumberSet = new HashSet<>();

        do {
            gameNumberSet.add(Randoms.pickNumberInRange(Inclusive.START.getValue(), Inclusive.END.getValue()));
        } while (gameNumberSet.size() < RuleVo.getGameNumbersLen());

        return new ArrayList<>(gameNumberSet);
    }

    @Test
    void List를_서로_비교해서_야구게임의_결괏값_배열_생성() {
        List<Integer> gameNumberList = new ArrayList<>(Arrays.asList(3, 6, 5)); // 상대방(컴퓨터)가 가진 야구게임 값
        List<Integer> playerGameNumberList = new ArrayList<>(Arrays.asList(3, 5, 6)); // Player가 가진 야구게임 값
        Integer[] gameResult = {0, 0}; // 결괏값
        for (int i = 0; i < playerGameNumberList.size(); i++) {
            Integer findIdx = gameNumberList.indexOf(playerGameNumberList.get(i));
            if (findIdx == -1) continue;
            if (findIdx != i) ++gameResult[0]; // 볼
            if (findIdx == i) ++gameResult[1]; // 스트라이크
        }
        assertEquals(2, gameResult[0]); // 볼
        assertEquals(1, gameResult[1]); // 스트라이크
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
