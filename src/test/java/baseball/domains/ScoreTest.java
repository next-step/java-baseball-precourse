package baseball.domains;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ScoreTest {

    @ParameterizedTest
    @CsvSource(value = {"123:123:3스트라이크", "123:312:3볼","123:456:낫싱"}, delimiter = ':')
    void Should_3Strike_When_SameString(String playerAimPosition, String computerAimPosition, String expect) {
        // given
        final Player player = new Player();
        player.decideAimPositions(playerAimPosition);

        final Computer computer = new Computer();
        computer.decideAimPositions(computerAimPosition);
        // when
        final String result = Score.calculate(player, computer);
        // then
        assertThat(result).isEqualTo(expect);
    }
}
