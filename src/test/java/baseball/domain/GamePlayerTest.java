package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GamePlayerTest {

    private GamePlayer gamePlayer;

    @BeforeEach
    void gamePlayerSettings() {
        gamePlayer = new GamePlayer();
    }

    @ParameterizedTest
    @DisplayName("정상적으로 Player Balls 생성 테스트")
    @ValueSource(strings = {"123", "567", "879"})
    void ballsCreationTest(String testStr) {
        gamePlayer.settingPlayerBalls(testStr);
        assertThat(gamePlayer.getBallsNumber()).isEqualTo(testStr);
    }
}
