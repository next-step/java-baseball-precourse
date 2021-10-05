package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class GamePlayerTest {

    private GamePlayer gamePlayer;
    private Balls testBalls;

    private Ball b1;
    private Ball b2;
    private Ball b3;

    @BeforeEach
    void gamePlayerSettings() {
        gamePlayer = new GamePlayer();

        b1 = new Ball(1,1);
        b2 = new Ball(2,2);
        b3 = new Ball(3, 3);
        testBalls = new Balls(new ArrayList<>(Arrays.asList(b1,b2,b3)));

    }

    @ParameterizedTest
    @DisplayName("정상적으로 Player Balls 생성 테스트")
    @ValueSource(strings = {"123", "567", "879"})
    void ballsCreationTest(String testStr) {
        gamePlayer.settingPlayerBalls(testStr);
        assertThat(gamePlayer.getBallsNumber()).isEqualTo(testStr);
    }


    @ParameterizedTest
    @DisplayName("3스트라이크 테스트")
    @ValueSource(strings = {"123"})
    void strikeTest(String str) {

        gamePlayer.settingPlayerBalls(str);

        assertThat(testBalls.calculate(gamePlayer.getBalls())).isEqualTo("3스트라이크 ");

    }

    @ParameterizedTest
    @DisplayName("1스트라이크 2볼 테스트")
    @ValueSource(strings = {"321"})
    void strike1ball2Test(String str) {

        gamePlayer.settingPlayerBalls(str);

        assertThat(testBalls.calculate(gamePlayer.getBalls())).isEqualTo("1스트라이크 2볼 ");

    }


    @ParameterizedTest
    @DisplayName("3볼 테스트")
    @ValueSource(strings = {"312"})
    void ball3Test(String str) {

        gamePlayer.settingPlayerBalls(str);

        assertThat(testBalls.calculate(gamePlayer.getBalls())).isEqualTo("3볼 ");

    }






}
