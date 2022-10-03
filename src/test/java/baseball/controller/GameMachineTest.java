package baseball.controller;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GameMachineTest extends NsTest {

    @ParameterizedTest
    @ValueSource(strings = {"3", "1234", "a", "0", "abcd", "\n"})
    void 사용자_입력값_유효성_예외_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new GameMachine().validateUserInput(input);
        });

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
