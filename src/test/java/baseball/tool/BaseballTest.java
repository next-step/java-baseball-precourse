package baseball.tool;

import baseball.ball.ComputerBaseball;
import baseball.ball.UserBaseball;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballTest {

    @ParameterizedTest
    @ValueSource(strings = {"1234", "1", "12"})
    public void Exception_테스트(String value) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> UserException(value))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    void UserException(String value) {
        UserBaseball baseball = new UserBaseball(value);
        baseball.checkValidation();
    }

    void ComputerException() {
        ComputerBaseball computerBaseball = new ComputerBaseball();
        computerBaseball.checkValidation();
    }

}