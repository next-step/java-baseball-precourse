package baseball;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.service.BaseballService;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    @DisplayName("existence userNumber ")
    void existence_userNumber() {

        // given
        User user = new User();
        user.setUserNumbers(new int [] { 1, 3, 9 });

        // when then
        assertThat(user.getUserNumbers()).isNotNull();
    }

    @Test
    @DisplayName("randomBotResetTest")
    void randomBotResetTest() {

        // given
        Computer computer = new Computer();
        computer.ballCountInc();
        computer.strikeCountInc();

        // when
        computer.resetGame();

        // then
        assertThat(computer.getBallCount()).isEqualTo(0);
        assertThat(computer.getStrikeCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("userInputValidCheck")
    void userInputValidCheck() throws IllegalArgumentException{
        // given
        User user = new User();
        user.setUserNumbers(new int[]{1, 2});
        // when
        int length = user.getUserNumbers().length;
        // then
        assertThatThrownBy(() -> validatePostcode(length)).isInstanceOf(IllegalArgumentException.class);
    }

    static void validatePostcode(int inputLength) throws IllegalArgumentException{
        if(inputLength != 3)
            throw  new IllegalArgumentException();
    }
}
