package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NothingTest {

    @DisplayName("낫싱 텍스트를 생성한다.")
    @Test
    void text() {
        Nothing nothing = new Nothing();
        assertThat(nothing.getText()).isEqualTo(Rule.NOTHING.getName());
    }
}