package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    @Test
    @DisplayName("컴퓨터 임의 숫자 생성")
    void generate(){
        Computer computer = new Computer();
        assertEquals(3, computer.getSize());
    }

    @Test
    @DisplayName("플레이어 입력")
    void input(){
        Player player = new Player("123");
        assertEquals(3, player.getSize());
        assertEquals(1, player.getValue(0));
        assertEquals(2, player.getValue(1));
        assertEquals(3, player.getValue(2));
    }

    @Test
    @DisplayName("중복 검사 - 중복값 입력")
    void validateDuplicate(){
        assertThatThrownBy(() -> {
            Player player = new Player("113");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 값을 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("예외 처리 - 3자리 초과 입력")
    void validateInputExceed(){
        assertThatThrownBy(() -> {
            Player player = new Player("1234");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 최대 세 자릿수까지 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("예외 처리 - 3자리 미만 입력")
    void validateInputLess(){
        assertThatThrownBy(() -> {
            Player player = new Player("12");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 최소 세 자릿수까지 입력해야 합니다.");
    }
}
