package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    @Test
    @DisplayName("입력한 숫자 확인")
    void retrieveInputNumber() {
        // given
        String numStr = "123";
        // when
        Player user = new User(numStr);
        // then
        assertThat(user.getNumbers().get(0)).isEqualTo(1);
        assertThat(user.getNumbers().get(1)).isEqualTo(2);
        assertThat(user.getNumbers().get(2)).isEqualTo(3);
    }
}
