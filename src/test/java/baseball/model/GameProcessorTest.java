package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameProcessorTest {

    List<Integer> test = new ArrayList<>();
    List<Integer> computer;
    List<String> OneStrikeTwoBallPlayer;
    List<String> ThreeStrikePlayer;

    @BeforeEach
    void Generate_Computer_Player_Number() {

        computer = new ArrayList<>();
        computer.add(1);
        computer.add(2);
        computer.add(3);

        OneStrikeTwoBallPlayer = new ArrayList<>();
        OneStrikeTwoBallPlayer.add("3");
        OneStrikeTwoBallPlayer.add("2");
        OneStrikeTwoBallPlayer.add("1");

        ThreeStrikePlayer = new ArrayList<>();
        ThreeStrikePlayer.add("1");
        ThreeStrikePlayer.add("2");
        ThreeStrikePlayer.add("3");

    }

    @Test
    @DisplayName("3스트라이크를 정상적으로 테스트한다.")
    void Test_Three_Strike() {
        GameProcessor gameProcessor = new GameProcessor(new Player(), new Computer());
        gameProcessor.calculateResult(computer, ThreeStrikePlayer);
        assertEquals(gameProcessor.STRIKE, gameProcessor.countStrike);
    }

    @Test
    @DisplayName("연속으로 게임을 실행해도, 정상적인 결과를 반환한다.")
    void Test_Continuous_Game() {
        GameProcessor gameProcessor = new GameProcessor(new Player(), new Computer());
        gameProcessor.calculateResult(computer, ThreeStrikePlayer);
        assertEquals(gameProcessor.STRIKE, gameProcessor.countStrike);

        gameProcessor.calculateResult(computer, OneStrikeTwoBallPlayer);
        assertEquals(1, gameProcessor.countStrike);
        assertEquals(2, gameProcessor.countBall);
    }

}