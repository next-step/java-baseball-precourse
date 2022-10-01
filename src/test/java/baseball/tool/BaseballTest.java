package baseball.tool;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballTest {

    @ParameterizedTest
    @ValueSource(ints = {1234, 1, 12})
    public void Exception_테스트(int value) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(value))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    void runException(int value) {
        Baseball baseball = new Baseball(value);
        baseball.checkTool();
    }

}