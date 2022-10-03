package baseball.referee;


import baseball.ball.domain.Ball;
import baseball.ball.domain.BallLocation;
import baseball.ball.domain.BallNumber;
import baseball.common.CharUtils;
import baseball.game.domain.Game;
import baseball.pitching.domain.Pitching;
import baseball.referee.domain.Referee;
import baseball.zone.domain.Zone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("심판 판정")
class RefereeTest {

    private Zone zone;

    @BeforeEach
    void setUp() {
        zone = new Zone();
        zone.addZone(BigDecimal.ONE);
        zone.addZone(BigDecimal.valueOf(2));
        zone.addZone(BigDecimal.valueOf(3));
    }

    @DisplayName("게임 종료 판정")
    @ParameterizedTest
    @MethodSource("threeStrike")
    void judgeGame(Pitching pitching) {
        Game game = new Game();
        game.start();
        Referee referee = new Referee(zone, pitching);
        referee.judgeGame(game);
        assertTrue(game.isEnd());
    }

    @DisplayName("0볼")
    @ParameterizedTest
    @MethodSource("noBall")
    void noBall(Pitching pitching) {
        Referee referee = new Referee(zone, pitching);
        assertThat(referee.judgeBallCount()).isEqualTo(0);
    }

    @DisplayName("1볼")
    @ParameterizedTest
    @MethodSource("oneBall")
    void oneBall(Pitching pitching) {
        Referee referee = new Referee(zone, pitching);
        assertThat(referee.judgeBallCount()).isEqualTo(1);
    }

    @DisplayName("2볼")
    @ParameterizedTest
    @MethodSource("twoBall")
    void twoBall(Pitching pitching) {
        Referee referee = new Referee(zone, pitching);
        assertThat(referee.judgeBallCount()).isEqualTo(2);
    }

    @DisplayName("3볼")
    @ParameterizedTest
    @MethodSource("threeBall")
    void threeBall(Pitching pitching) {
        Referee referee = new Referee(zone, pitching);
        assertThat(referee.judgeBallCount()).isEqualTo(3);
    }

    @DisplayName("노스트라이크")
    @ParameterizedTest
    @MethodSource("noStrike")
    void noStrike(Pitching pitching) {
        Referee referee = new Referee(zone, pitching);
        assertThat(referee.judgeStrikeCount()).isEqualTo(0);
    }

    @DisplayName("1스트라이크")
    @ParameterizedTest
    @MethodSource("oneStrike")
    void oneStrike(Pitching pitching) {
        Referee referee = new Referee(zone, pitching);
        assertThat(referee.judgeStrikeCount()).isEqualTo(1);
    }

    @DisplayName("2스트라이크")
    @ParameterizedTest
    @MethodSource("twoStrike")
    void twoStrike(Pitching pitching) {
        Referee referee = new Referee(zone, pitching);
        assertThat(referee.judgeStrikeCount()).isEqualTo(2);
    }

    @DisplayName("3스트라이크")
    @ParameterizedTest
    @MethodSource("threeStrike")
    void threeStrike(Pitching pitching) {
        Referee referee = new Referee(zone, pitching);
        assertThat(referee.judgeStrikeCount()).isEqualTo(3);
    }

    private static Stream<Arguments> oneStrike() {
        return Stream.of(
                Arguments.arguments(createPitching("156".toCharArray()), 0),
                Arguments.arguments(createPitching("425".toCharArray()), 0),
                Arguments.arguments(createPitching("453".toCharArray()), 0)
        );
    }

    private static Stream<Arguments> twoStrike() {
        return Stream.of(
                Arguments.arguments(createPitching("125".toCharArray()), 0),
                Arguments.arguments(createPitching("523".toCharArray()), 0),
                Arguments.arguments(createPitching("153".toCharArray()), 0)
        );
    }

    private static Stream<Arguments> threeStrike() {
        return Stream.of(
                Arguments.arguments(createPitching("123".toCharArray()), 0)
        );
    }

    private static Stream<Arguments> oneBall() {
        return Stream.of(
                Arguments.arguments(createPitching("245".toCharArray()), 1),
                Arguments.arguments(createPitching("435".toCharArray()), 1),
                Arguments.arguments(createPitching("451".toCharArray()), 1)
        );
    }

    private static Stream<Arguments> twoBall() {
        return Stream.of(
                Arguments.arguments(createPitching("214".toCharArray()), 2),
                Arguments.arguments(createPitching("341".toCharArray()), 2),
                Arguments.arguments(createPitching("432".toCharArray()), 2)
        );
    }

    private static Stream<Arguments> threeBall() {
        return Stream.of(
                Arguments.arguments(createPitching("231".toCharArray()), 3)
        );
    }

    private static Stream<Arguments> noBall() {
        return Stream.of(
                Arguments.arguments(createPitching("456".toCharArray()), 0)
        );
    }

    private static Stream<Arguments> noStrike() {
        return Stream.of(
                Arguments.arguments(createPitching("456".toCharArray()), 0)
        );
    }

    private static Pitching createPitching(char[] numbers) {
        Pitching pitching = new Pitching();
        for (char number : numbers) {
            pitching.add(createBall(CharUtils.convertBigDecimal(number), pitching.pitchingBalls().size() + 1));
        }
        return pitching;
    }

    private static Ball createBall(BigDecimal firstBallNumber, int firstBallLocation) {
        return new Ball(new BallNumber(firstBallNumber), new BallLocation(BigDecimal.valueOf(firstBallLocation)));
    }

}
