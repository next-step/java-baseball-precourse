package baseball.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @DisplayName("3자리 이상의 숫자를 입력했을 경우")
    @Test
    public void throwErrorInCaseInvalidLength() {
        String userinput = "1234";

        assertThatThrownBy(() -> new Player(userinput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("3자리의 숫자만 입력할 수 있습니다.");
    }

    @DisplayName("입력한 값에 중복되는 숫자가 있는 경우")
    @Test
    public void throwErrorInCaseDuplicate() {
        String userinput = "112";

        assertThatThrownBy(() -> new Player(userinput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("서로 다른 3가지 숫자를 입력해주세요.");
    }

    @DisplayName("숫자가 아닌 다른 값을 입력한 경우")
    @Test
    public void throwErrorInCaseNotNumber() {
        String userinput = "abc";

        assertThatThrownBy(() -> new Player(userinput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("1~9 범위의 3자리 숫자만 입력할 수 있습니다.");
    }
}
