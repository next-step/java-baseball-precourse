package baseball.model;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PlayGroundTest {
    private PlayGround playGround;

    @BeforeEach
    void setup() {
        this.playGround = new PlayGround();

        this.playGround.setComputerTrial(new PlayerState(Arrays.asList(1, 2, 3)));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,True", "1,3,4,False", "3,2,1,False", "1,4,5,False"}, delimiter = ',')
    void 공_번호_3개가_주어졌을_때_컴퓨터가_선택한_수와_비교_후_결과를_리턴한다(int firstBallNum, int secondBallNum, int thirdBallNum, boolean expected) {
        Assertions.assertThat(this.playGround.run(new PlayerState(Arrays.asList(firstBallNum, secondBallNum, thirdBallNum)))).isEqualTo(expected);
    }
}
