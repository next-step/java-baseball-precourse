package baseball.game;

import baseball.console.ConsoleInterface;
import baseball.score.ScoreBoard;
import baseball.score.ScoreGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class BaseballGameLauncherTest {
    
    @ParameterizedTest
    @MethodSource("argumentsStream")
    void compareMockTest(ScoreBoard inputScore, boolean expected) {
        ConsoleInterface consoleInterface = mock(ConsoleInterface.class);
        ScoreGenerator scoreGenerator = mock(ScoreGenerator.class);
        BaseballGameLauncher gameLauncher = new BaseballGameLauncher(consoleInterface, scoreGenerator);
        
        ScoreBoard initScore = new ScoreBoard(1, 2, 3);
        
        boolean isContinue = gameLauncher.compare(initScore, inputScore);
        
        assertEquals(expected, isContinue);
    }
    
    private static Stream<Arguments> argumentsStream() {
        return Stream.of(
                Arguments.of(
                        new ScoreBoard(1, 2, 3),
                        false
                ),
                Arguments.of(
                        new ScoreBoard(9, 2, 1),
                        true
                ),
                Arguments.of(
                        new ScoreBoard(5, 4, 8),
                        true
                )
        );
    }
}
