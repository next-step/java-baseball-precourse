package baseball.domain;

import static baseball.type.GameSettingType.NUMBER_SIZE;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.number.Number;
import baseball.domain.number.PlayerNumber;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerNumberTest {

    @Test
    @DisplayName("입력한 숫자로 playerNumber가 생성된다.")
    void playerNumber_create() {
        PlayerNumber playerNumber = new PlayerNumber("123");
        Set<Number> playerNumbers = playerNumber.getPlayerNumbers();
        assertThat(playerNumbers.size()).isEqualTo(NUMBER_SIZE.getValue());
    }
}