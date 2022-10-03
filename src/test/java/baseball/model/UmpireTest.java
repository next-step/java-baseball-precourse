package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UmpireTest {
    private List<Integer> computerBalls;

    @BeforeEach
    void setUp() {
        this.computerBalls = Arrays.asList(5, 1, 3);
    }

    @Test
    @DisplayName("낫싱 테스트")
    void noting_test() {
        // given
        List<Integer> playerBalls = Arrays.asList(2, 7, 6);

        // when
        Umpire umpire = new Umpire();
        umpire.initGame(computerBalls, playerBalls);
        GameState gameState = umpire.judge();

        // then
        assertThat(gameState).isEqualTo(GameState.DEFEAT);
        assertThat(umpire.result()).isEqualTo(Umpire.NOTHING_FORMAT);
        assertThat(umpire.getBallCount()).isZero();
        assertThat(umpire.getStrikeCount()).isZero();
    }

    @Test
    @DisplayName("승리 테스트")
    void victory_test() {
        // given
        List<Integer> playerBalls = Arrays.asList(5, 1, 3);

        // when
        Umpire umpire = new Umpire();
        umpire.initGame(computerBalls, playerBalls);
        GameState gameState = umpire.judge();

        // then
        assertThat(gameState).isEqualTo(GameState.VICTORY);
        assertThat(umpire.result()).isEqualTo(String.format(Umpire.STRIKE_FORMAT, 3));
    }

    @ParameterizedTest
    @DisplayName("스트라이크 테스트")
    @CsvSource(value = {"512:2", "531:1", "214:1", "513:3", "247:0"}, delimiter = ':')
    void strike_test(String input, int expected) {
        // given
        Player player = new Player();
        player.inputBalls(input);

        // when
        Umpire umpire = new Umpire();
        umpire.initGame(computerBalls, player.balls());
        umpire.judge();

        // then
        assertThat(umpire.getStrikeCount()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("볼 테스트")
    @CsvSource(value = {"324:1", "531:2", "789:0", "351:3", "371:2"}, delimiter = ':')
    void ball_test(String input, int expected) {
        // given
        Player player = new Player();
        player.inputBalls(input);

        // when
        Umpire umpire = new Umpire();
        umpire.initGame(computerBalls, player.balls());
        umpire.judge();

        // then
        assertThat(umpire.getBallCount()).isEqualTo(expected);
    }

    @Test
    @DisplayName("결과 메세지 테스트")
    void result_message_test() {
        // given
        List<Integer> playerBalls21 = Arrays.asList(5, 3, 1); // 2볼 1스트라이크
        List<Integer> playerBalls20 = Arrays.asList(3, 7, 1); // 2볼
        List<Integer> playerBalls01 = Arrays.asList(5, 2, 4); // 1스트라이크

        // when
        Umpire umpire = new Umpire();
        Umpire umpire2 = new Umpire();
        Umpire umpire3 = new Umpire();
        umpire.initGame(computerBalls, playerBalls21);
        umpire2.initGame(computerBalls, playerBalls20);
        umpire3.initGame(computerBalls, playerBalls01);
        umpire.judge();
        umpire2.judge();
        umpire3.judge();

        // then
        assertThat(umpire.result()).isEqualTo("2볼 1스트라이크");
        assertThat(umpire2.result()).isEqualTo("2볼");
        assertThat(umpire3.result()).isEqualTo("1스트라이크");
    }
}