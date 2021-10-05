package baseball.controller;

import baseball.domain.GameConfig;
import baseball.domain.GameStatus;
import baseball.domain.PickNumberMatchResultView;
import baseball.service.GameService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;

import static baseball.AppConfig.*;
import static baseball.domain.PickNumbers.*;
import static org.assertj.core.api.Assertions.assertThat;

class GameControllerTest {

    @BeforeEach
    void beforeEach() {
        makePickNumbers();
    }

    @AfterEach
    void afterEach() {
        setGameStatusStart();
    }

    @Test
    @DisplayName("싱글톤 객체 주입 확인")
    void checkSingletonInject() {
        GameService gameService1 = getGameService();
        GameService gameService2 = getGameService();

        GameController gameController1 = getGameController();
        GameController gameController2 = getGameController();

        assertThat(gameService1).isSameAs(gameController2.getGameService());
        assertThat(gameService2).isSameAs(gameController1.getGameService());
    }

    @Test
    @DisplayName("게임이 시작되면 게임상태는 항상 시작상태이다")
    void newGameStatusIsStart() {
        assertThat(getGameStatus()).isEqualTo(GameStatus.START);
    }

    @Test
    @DisplayName("3자리 수를 생성한다")
    void makePickNumbersTest() {
        LinkedHashSet<Integer> pickNumbersSet = getPickNumbersSet();

        assertThat(pickNumbersSet.size()).isEqualTo(GameConfig.PICK_NUMBER_SIZE.getValue());
    }

    @DisplayName("게임을 새로 시작하려면 1, 종료하려면 2를 입력한다")
    @ParameterizedTest(name = "게임상태 [{0}]")
    @ValueSource(ints = {1, 2})
    void choiceGameStatusResultTest(int input) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        GameController gameController = getGameController();

        Method method = gameController.getClass().getDeclaredMethod("choiceGameStatusResult", int.class);
        method.setAccessible(true);

        if (input == 1) {
            method.invoke(gameController, input);
            assertThat(getGameStatus()).isEqualTo(GameStatus.START);
        } else {
            method.invoke(gameController, input);
            assertThat(getGameStatus()).isEqualTo(GameStatus.END);
        }

    }

}