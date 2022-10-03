package baseball.model;


import static org.assertj.core.api.Assertions.*;

import baseball.common.PlayBaseStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayResultTest {
    @Test
    @DisplayName("valueOfTest:[succss]")
    void valueOfTest() {
        //given
        String gameResult = "3 스트라이크";
        PlayBaseStatus baseStatus = PlayBaseStatus.OVER;
        //when
        PlayResult playResult = PlayResult.valueOf(gameResult, baseStatus);
        //then
        assertThat(playResult.getAnswer()).isEqualTo(gameResult);
        assertThat(playResult.getStatus()).isEqualTo(baseStatus);
    }
}