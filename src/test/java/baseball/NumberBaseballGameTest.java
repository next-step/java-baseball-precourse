package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberBaseballGameTest {

    @Test
    @DisplayName("상대방(컴퓨터) 설정 확인")
    void setup_computer(){
        NumberBaseballGame game = new NumberBaseballGame(3);
        assertThat(game).isNotNull();
        assertThat(game.isPlay()).isTrue();
    }

}