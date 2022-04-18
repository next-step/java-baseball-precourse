package baseball.player;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PitcherTest extends NsTest {
    @Test
    @DisplayName("투구_숫자_검증_테스트")
    void 투구_숫자_검증_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("123"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        new Pitcher().pitch();
    }
}
