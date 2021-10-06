package baseball;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PlayResultTest {
    private PlayerState playerState;

    @BeforeEach
    void setup() {
        this.playerState = new PlayerState(Arrays.asList(1, 2, 3));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,3스트라이크", "1,2,4,2스트라이크", "1,3,4,1스트라이크 1볼",
            "2,3,1,3볼", "4,5,3,1스트라이크", "3,4,5,1볼", "4,5,6,낫싱"}, delimiter = ',')
    void 플레이한_게임의_결과를_출력한다(int firstBallNum, int secondBallNum, int thirdBallNum, String expected) {
        PlayResult result = this.playerState.play(new PlayerState(Arrays.asList(firstBallNum, secondBallNum, thirdBallNum)));

        Assertions.assertThat(result.toString()).isEqualTo(expected);
    }
}
