package baseball.controller;

import baseball.domain.GameConfig;
import baseball.service.GameService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;

import static baseball.AppConfig.getGameService;
import static baseball.domain.PickNumbers.getPickNumbersSet;
import static baseball.domain.PickNumbers.makePickNumbers;
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

    @Test
    @DisplayName("랜덤한 3자리 수 생성 (중복제거)")
    void makePickNumbersTest() {
        LinkedHashSet<Integer> pickNumbersSet = new LinkedHashSet<>();
        int pickNumber = 0;

        boolean isMakePickNumbers = makePickNumbers();
        if (isMakePickNumbers) {
            pickNumbersSet = getPickNumbersSet();

            StringBuilder sb = new StringBuilder();
            for (Integer pick : pickNumbersSet) {
                sb.append(pick);
            }
            pickNumber = Integer.parseInt(sb.toString());
        }

        System.out.println("pickNumber = " + pickNumber);
        assertThat(pickNumber).isGreaterThanOrEqualTo(123).isLessThanOrEqualTo(987);

        System.out.println("pickNumbersSet.size() = " + pickNumbersSet.size());
        assertThat(pickNumbersSet.size()).isEqualTo(GameConfig.PICK_NUMBER_SIZE.getValue());
    }

}