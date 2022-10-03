package baseball.domain;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class StrikeBallsTest extends NsTest {
    @Test
    void StrikeBalls_생성자_호출_시_값_생성_테스트() {
        StrikeBalls strikeBalls = new StrikeBalls();
        assertThat(strikeBalls).isNotNull();
        String testVal = new String();
        for (int i = 0; i < StrikeBalls.NUM_BALL_LEN; i++) {
            testVal += strikeBalls.getStrikeBall(i);
        }
        assertThat(testVal.matches("^[1-9]*$"));
    }

    @Test
    void 중복되지_않은_숫자_생성_테스트() {
        StrikeBalls strikeBalls = new StrikeBalls();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < StrikeBalls.NUM_BALL_LEN; i++) {
            set.add(strikeBalls.getStrikeBall(i));
        }
        assertThat(set).hasSize(3);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
