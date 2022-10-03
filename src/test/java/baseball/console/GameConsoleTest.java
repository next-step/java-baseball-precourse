package baseball.console;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameConsoleTest {
    
    @Test
    @DisplayName("입력문자 검증 테스트")
    void validInputTest() {
        GameConsole gameConsole = new GameConsole();
        
        assertAll(
                () -> assertTrue(gameConsole.validInput("123")),
                () -> assertTrue(gameConsole.validInput("321")),
                () -> assertTrue(gameConsole.validInput("999")),
                () -> assertFalse(gameConsole.validInput("001")),
                () -> assertFalse(gameConsole.validInput("330")),
                () -> assertFalse(gameConsole.validInput("1")),
                () -> assertFalse(gameConsole.validInput("2")),
                () -> assertFalse(gameConsole.validInput("abc"))
        );
        
    }
}
