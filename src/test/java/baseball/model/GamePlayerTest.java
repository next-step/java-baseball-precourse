package baseball.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GamePlayerTest {

    @ParameterizedTest
    @CsvSource(value = {"123:3:3", "2567:4:4"}, delimiter = ':')
    void 플레이어가_생성한_숫자의_자리수는_예상한바와_맞음(String readNumber, int numberTotalLength, int expectedLength) {
        NumberControl numberControl = new NumberControl(numberTotalLength, 1, 9);
        GamePlayer gamePlayer = new GamePlayer(new ReadLineNumberGenerator(readNumber), numberControl);
        assertThat(gamePlayer.getNumber().size()).isEqualTo(expectedLength);
    }
}