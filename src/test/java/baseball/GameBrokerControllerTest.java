package baseball;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class GameBrokerControllerTest {

    @Test
    void 유저_입력_유효성_검사() {
        GameBrokerController broker = new GameBrokerController();
        assertThat(broker.isValidInput("234")).isTrue();
        assertThat(broker.isValidInput("1233")).isFalse();
        assertThat(broker.isValidInput("invalid")).isFalse();
        assertThat(broker.isValidInput("333")).isFalse();
    }

    @Test
    void 유저_입력_해시셋_파싱() {
        GameBrokerController broker = new GameBrokerController();
        int[] result = broker.parseString("345");

        assertThat(result)
                .contains(3)
                .contains(4)
                .contains(5);

    }

    @Test
    void 게임_성공후_종료_확인() {
        GameBrokerController broker = new GameBrokerController();
        assertThat(broker.willContinue("1")).isTrue();
        assertThat(broker.willContinue("2")).isFalse();
    }
}
