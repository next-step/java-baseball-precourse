package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameTest {

    @ParameterizedTest
    @CsvSource(value = {"123:123:3", "132:312:1", "423:453:2", "358:249:0"}, delimiter = ':')
    void 입력한_값이_변경됨에_따라_스크라이크_개수가_예상처럼_나옴(String readNumber, String computerNumber, int expectStikeCount) {
        NumberControl numberControl = new NumberControl(3, 1, 9);
        Computer computer = new Computer(new ReadLineNumberGenerator(computerNumber), numberControl); // 실제 컴퓨터는 랜덤으로 뽑아야 하나, 그러면 체크가 어려워 player와 동일하게 테스트
        GamePlayer gamePlayer = new GamePlayer(new ReadLineNumberGenerator(readNumber), numberControl);

        GameResult gameResult = new Game(computer, gamePlayer).getGameResult();
        assertThat(gameResult.getStrike()).isEqualTo(expectStikeCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"123:123:0", "132:312:2", "423:453:0", "458:249:1"}, delimiter = ':')
    void 입력한_값이_변경됨에_따라_볼_개수가_예상처럼_나옴(String readNumber, String computerNumber, int expectBallCount) {
        NumberControl numberControl = new NumberControl(3, 1, 9);
        Computer computer = new Computer(new ReadLineNumberGenerator(computerNumber), numberControl); // 실제 컴퓨터는 랜덤으로 뽑아야 하나, 그러면 체크가 어려워 player와 동일하게 테스트
        GamePlayer gamePlayer = new GamePlayer(new ReadLineNumberGenerator(readNumber), numberControl);

        GameResult gameResult = new Game(computer, gamePlayer).getGameResult();
        assertThat(gameResult.getBall()).isEqualTo(expectBallCount);
    }

}