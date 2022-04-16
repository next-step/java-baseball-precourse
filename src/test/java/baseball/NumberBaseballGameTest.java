package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class NumberBaseballGameTest {

    private NumberBaseballGame game;
    @BeforeEach
    void setup(){
        game = new NumberBaseballGame(3);
    }

    @Test
    @DisplayName("상대방(컴퓨터) 설정 확인")
    void setup_computer(){
        assertThat(game).isNotNull();
        assertThat(game.isPlay()).isTrue();
    }

    @ParameterizedTest
    @DisplayName("숫자 검증후 예외처리")
    @ValueSource(strings = {"", "12","1234", "112"})
    void user_validate_number(String testValue){
        assertThatIllegalArgumentException().isThrownBy(() -> game.validateNumber(testValue));
    }

    @ParameterizedTest
    @DisplayName("숫자 검증후 예외처리")
    @ValueSource(strings = {"123", "456","789"})
    void play_the_game(String testValue){
        assertDoesNotThrow(() -> game.playing(testValue));
    }

}
