package baseball.domain;

import static baseball.type.GameSettingType.NUMBER_SIZE;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.number.ComputerNumber;
import baseball.domain.number.Number;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerNumberTest {

    @Test
    @DisplayName("컴퓨터가 사용하는 숫자는 중복되지 않은 3자리 수이다.")
    void computerNumber_notDuplicate() {
        ComputerNumber computerNumber = new ComputerNumber();
        Set<Number> computerNumbers = computerNumber.getComputerNumbers();
        assertThat(computerNumbers.size()).isEqualTo(NUMBER_SIZE.getValue());
    }
}