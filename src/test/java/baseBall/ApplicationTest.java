package baseBall;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

class ApplicationTest {
    @Test
    @ParameterizedTest
    @ValueSource(strings = {"1\n123\n345\n678\n901\n345\n935\n948\n965\n125\n353\n2"})
    @DisplayName("정상 범위 9번")
    void justRun(String input){
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        GameMenu gameMenu = new GameMenu();
        Assertions.assertDoesNotThrow(()-> gameMenu.run());
    }

    @Test
    @ParameterizedTest
    @ValueSource(strings = {"1\n123\n345\n6478\n901\n3445\n935\n948\n965\n125\n353\n453\n2"})
    @DisplayName("입렵 오류 2번 - 11번 호출")
    void justRunOverRound(String input){
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        GameMenu gameMenu = new GameMenu();
        Assertions.assertDoesNotThrow(()-> gameMenu.run());
    }
}