package baseball.console;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EndCodeTest {
    
    @Test
    @DisplayName("입력문자열에 따른 결과 응답 테스트")
    void isExitTest() {
        assertFalse(EndCode.isExit("1"));
        assertTrue(EndCode.isExit("2"));
    }
    
    @Test
    @DisplayName("허용된 입력문자가 아닐때 예외 발생 테스트")
    void isExitThrowExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> EndCode.isExit("0"));
    }
}
