package baseball.controller;

import baseball.AppConfig;
import baseball.service.GameService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseball.AppConfig.getGameController;
import static baseball.AppConfig.getGameService;
import static org.assertj.core.api.Assertions.assertThat;

class GameControllerTest {

    @Test
    @DisplayName("싱글톤 객체 주입 확인")
    void checkSingletonInject() {
        GameService gameService1 = getGameService();
        GameService gameService2 = getGameService();

        GameController gameController1 = new GameController(gameService1);
        GameController gameController2 = new GameController(gameService2);

        assertThat(gameService1).isSameAs(gameController2.getGameService());
        assertThat(gameService2).isSameAs(gameController1.getGameService());
    }

}