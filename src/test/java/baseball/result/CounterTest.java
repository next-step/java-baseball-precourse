package baseball.result;

import baseball.input.bean.Player;
import baseball.result.bean.Computer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("숫자 비교 counter 테스트")
public class CounterTest {
    private Counter counter;
    private Converter converter;
    private Player player;
    private Computer computer;
    @BeforeEach
    void setUp() {
        this.player = new Player();
        this.computer = new Computer();
        this.converter = new Converter();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "321, 431, 2",
            "321, 341, 2",
            "321, 391, 2",
            "321, 193, 2",
            "321, 321, 3",
            "321, 123, 3",
            "123, 452, 1"
    })
    void 숫자_일치_테스트(String playerNumbersText, String computerNumbersText, int expected) {
        this.player.setNumbers(playerNumbersText);
        this.computer.setNumbers(computerNumbersText);
        this.counter = new Counter(this.player, this.computer);
        int actual = counter.containsDigitNumberCount();
        assertThat(actual).isEqualTo(expected);

    }

    @ParameterizedTest
    @CsvSource(value = {
            "321, 431, 1",
            "321, 341, 2",
            "321, 391, 2",
            "321, 193, 0",
            "321, 321, 3",
            "321, 123, 1",
            "123, 452, 0"
    })
    void 순서_숫자_모두_일치_테스트(String playerNumbersText, String computerNumbersText, int expected) {
        this.player.setNumbers(playerNumbersText);
        this.computer.setNumbers(computerNumbersText);
        this.counter = new Counter(this.player, this.computer);
        int actual = counter.equalDigitNumberCount();

        assertThat(actual).isEqualTo(expected);
    }
}
