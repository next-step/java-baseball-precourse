package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseballGameModelTest {
    BaseballGameModel baseballGameModel;

    @BeforeEach
    void setUp() {
        baseballGameModel = new BaseballGameModel(
                Arrays.asList(1, 2, 3)
        );
    }

    @Test
    void 정답_테스트() {
        baseballGameModel.playOneInning(
                Arrays.asList(1, 2, 3)
        );
        assertThat(!baseballGameModel.result.isNothing());
        assertThat(baseballGameModel.result.getStrike() == 3);
        assertThat(baseballGameModel.result.isEndedInning());
    }

    @Test
    void 스트라이크_볼_테스트() {
        baseballGameModel.playOneInning(
                Arrays.asList(1, 3, 5)
        );
        assertThat(baseballGameModel.result.getStrike() == 1);
        assertThat(baseballGameModel.result.getBall() == 1);
        assertThat(!baseballGameModel.result.isNothing());

        baseballGameModel.playOneInning(
                Arrays.asList(3, 5, 6)
        );
        assertThat(baseballGameModel.result.getStrike() == 0);
        assertThat(baseballGameModel.result.getBall() == 1);
        assertThat(!baseballGameModel.result.isNothing());
    }

    @Test
    void 낫싱_테스트() {
        baseballGameModel.playOneInning(
                Arrays.asList(4, 5, 6)
        );
        assertThat(baseballGameModel.result.getStrike() == 0);
        assertThat(baseballGameModel.result.getBall() == 0);
        assertThat(!baseballGameModel.result.isNothing());
    }

    @Test
    void 생성_예외_태스트() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new BaseballGameModel(Arrays.asList(1, 2, 3, 4))
        );
        assertThatIllegalArgumentException().isThrownBy(
                () -> new BaseballGameModel(Arrays.asList(0, 1, 2, 3))
        );
        assertThatIllegalArgumentException().isThrownBy(
                () -> new BaseballGameModel(Arrays.asList(1, 2, 10))
        );
    }
}
