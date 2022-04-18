package baseBall;

import domain.RoundResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class GameProcessTest {
    @Test
    @DisplayName("2Ball 0Strike")
    void roundTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        GameProcess gameProcess = new GameProcess();

        Method roundProcessing = GameProcess.class.getDeclaredMethod("roundProcessing", String.class, String.class);
        roundProcessing.setAccessible(true);

        String userInput = "345";
        String gameNumber = "539";

        RoundResult roundResult = (RoundResult) roundProcessing.invoke(gameProcess, userInput, gameNumber);
        Assertions.assertThat(roundResult.getStrikeCount()).isEqualTo(0);
        Assertions.assertThat(roundResult.getBallCount()).isEqualTo(2);
    }

    @Test
    void charAt(){
        String userInput = "345";
        String gameNumber = "539";

        Assertions.assertThat(userInput.charAt(0)==gameNumber.charAt(1)).isTrue();
    }
}