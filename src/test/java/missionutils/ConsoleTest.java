package missionutils;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsoleTest {

    MockedStatic<Console> staticConsole;
    final String INPUT = "input";

    @BeforeEach
    public void before() {
        staticConsole = Mockito.mockStatic(Console.class);
        staticConsole.when(Console::readLine)
                .thenReturn(INPUT);
    }

    @Test
    public void readLine() {
        String input = Console.readLine();
        assertThat(input).isEqualTo(INPUT);
    }

    @AfterEach
    public void after() {
        staticConsole.close();
    }
}
