package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ComputerTest {
    @DisplayName("컴퓨터는 입력값에 대해 strike 개수를 구할 수 있다")
    @ParameterizedTest
    @CsvSource(value = {"123:1", "185:1", "238:2", "138:3", "418:1", "538:2"}, delimiter = ':')
    void 스트라이크_개수를_구한다(String input, String expect) {
        Computer computer = new Computer("138");
        assertThat(computer.getStrikeCount(input)).isEqualTo(Integer.parseInt(expect));
    }

    @DisplayName("컴퓨터는 입력값에 대해 ball 개수를 구할 수 있다")
    @ParameterizedTest
    @CsvSource(value = {"123:0", "185:1", "163:1", "654:2", "615:2", "564:3"}, delimiter = ':')
    void 볼_개수를_구한다(String input, String expect) {
        Computer computer = new Computer("456");
        assertThat(computer.getBallCount(input)).isEqualTo(Integer.parseInt(expect));
    }
}
