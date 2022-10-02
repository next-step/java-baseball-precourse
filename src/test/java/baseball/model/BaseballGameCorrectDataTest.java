package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseballGameCorrectDataTest {
    private BaseballGameCorrectData correctData;

    @BeforeEach
    void setUp() {
        correctData = new BaseballGameCorrectData(
                Arrays.asList(1, 2, 3)
        );
    }

    @Test
    void 스트라이크_테스트() {
        assertThat(correctData.pitch(new PitchingInput(1, 0)).equals(PitchingResult.STRIKE));
        assertThat(correctData.pitch(new PitchingInput(2, 1)).equals(PitchingResult.STRIKE));
        assertThat(correctData.pitch(new PitchingInput(3, 2)).equals(PitchingResult.STRIKE));
    }

    @Test
    void 볼_테스트() {
        assertThat(correctData.pitch(new PitchingInput(1, 1)).equals(PitchingResult.BALL));
        assertThat(correctData.pitch(new PitchingInput(1, 2)).equals(PitchingResult.BALL));
        assertThat(correctData.pitch(new PitchingInput(2, 0)).equals(PitchingResult.BALL));
        assertThat(correctData.pitch(new PitchingInput(2, 2)).equals(PitchingResult.BALL));
        assertThat(correctData.pitch(new PitchingInput(3, 1)).equals(PitchingResult.BALL));
        assertThat(correctData.pitch(new PitchingInput(3, 2)).equals(PitchingResult.BALL));
    }

    @Test
    void 낫싱_테스트() {
        assertThat(correctData.pitch(new PitchingInput(4, 0)).equals(PitchingResult.NOTHING));
        assertThat(correctData.pitch(new PitchingInput(5, 1)).equals(PitchingResult.NOTHING));
        assertThat(correctData.pitch(new PitchingInput(6, 2)).equals(PitchingResult.NOTHING));
        assertThat(correctData.pitch(new PitchingInput(7, 0)).equals(PitchingResult.NOTHING));
        assertThat(correctData.pitch(new PitchingInput(8, 1)).equals(PitchingResult.NOTHING));
        assertThat(correctData.pitch(new PitchingInput(9, 2)).equals(PitchingResult.NOTHING));
    }

    @Test
    void Order_예외_테스트() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> correctData.pitch(new PitchingInput(1, -1))
        );
        assertThatIllegalArgumentException().isThrownBy(
                () -> correctData.pitch(new PitchingInput(1, 4))
        );
    }
}
