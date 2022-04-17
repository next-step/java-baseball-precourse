package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JudgeTest {

    private Judge judge;
    private List<Integer> computer;
    private List<Integer> player;

    @BeforeEach
    void setUp() {
        judge = new Judge();

        computer = new ArrayList<>();
        computer.add(3);
        computer.add(1);
        computer.add(4);

        player = new ArrayList<>();
    }

    @ParameterizedTest
    @CsvSource(value = {"431,3", "123,2", "987,0"})
    void countBallTest(String stringPlayer, String expected) {
        setPlayer(stringPlayer);
        assertThat(judge.countBall(computer, player)).isEqualTo(Integer.valueOf(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"314,3", "341,1", "987,0", "413,1"})
    void countStrikeTest(String stringPlayer, String expected) {
        setPlayer(stringPlayer);
        assertThat(judge.countStrike(computer, player)).isEqualTo(Integer.valueOf(expected));
    }

    void setPlayer(String stringPlayer) {
        String[] temp = stringPlayer.split("");
        for(String sNumber : temp) {
            player.add(Integer.valueOf(sNumber));
        }
    }

}
