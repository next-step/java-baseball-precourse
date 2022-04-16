package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class NumberBaseballGameTest {

    @Test
    @DisplayName("상대방(컴퓨터) 설정 확인")
    void setup_computer(){
        NumberBaseballGame game = new NumberBaseballGame(3);
        assertThat(game).isNotNull();
        assertThat(game.isPlay()).isTrue();
    }

    @ParameterizedTest
    @DisplayName("숫자 검증후 예외처리")
    @ValueSource(strings = {"", "12","1234", "112"})
    void user_validate_number(String testValue){
        NumberBaseballGame game = new NumberBaseballGame(3);
        assertThatIllegalArgumentException().isThrownBy(() -> game.validateNumber(testValue));
    }

}