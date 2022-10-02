package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PlayerTest {

    @Test
    @DisplayName("유저가 승리 했을경우 TRUE 리턴 확인")
    void isWin() {
        //given
        Player mockPlayer = mock(Player.class);

        //when
        when(mockPlayer.isWin()).thenReturn(true);

        //then
        assertTrue(mockPlayer.isWin(), () -> "플레이어가 승리하였지만 True를 리턴하지 않았습니다.");
    }
}