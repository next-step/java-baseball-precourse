package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InningResultDataTest {

    InningResultData inningResultData;

    @BeforeEach
    void setUp() {
        inningResultData = new InningResultData();
    }

    @Test
    void 볼_테스트() {
        inningResultData.setPitchingResult(PitchingResult.BALL);
        assertThat(inningResultData.getBall() == 1);
        inningResultData.setPitchingResult(PitchingResult.BALL);
        assertThat(inningResultData.getBall() == 2);
        inningResultData.setPitchingResult(PitchingResult.BALL);
        assertThat(inningResultData.getBall() == 3);
    }

    @Test
    void 스트라이크_테스트() {
        inningResultData.setPitchingResult(PitchingResult.STRIKE);
        assertThat(inningResultData.getStrike() == 1);
        inningResultData.setPitchingResult(PitchingResult.STRIKE);
        assertThat(inningResultData.getStrike() == 2);
        inningResultData.setPitchingResult(PitchingResult.STRIKE);
        assertThat(inningResultData.getStrike() == 3);
    }

    @Test
    void 낫싱_테스트() {
        assertThat(inningResultData.isNothing());
        inningResultData.setPitchingResult(PitchingResult.STRIKE);
        assertThat(!inningResultData.isNothing());
    }

    @Test
    void 게임_종료_테스트() {
        assertThat(!inningResultData.isEndedInning());
        inningResultData.setPitchingResult(PitchingResult.STRIKE);
        inningResultData.setPitchingResult(PitchingResult.STRIKE);
        inningResultData.setPitchingResult(PitchingResult.STRIKE);
        assertThat(inningResultData.isEndedInning());
    }

    @Test
    void 투구_개수_예외_테스트() {
        inningResultData.setPitchingResult(PitchingResult.STRIKE);
        inningResultData.setPitchingResult(PitchingResult.STRIKE);
        inningResultData.setPitchingResult(PitchingResult.STRIKE);
        assertThatIllegalStateException().isThrownBy(
                () -> inningResultData.setPitchingResult(PitchingResult.STRIKE)
        );
    }
}
