package baseball.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class GameDataValidatorTest {
    @Test
    void Order_검증_테스트() {
        assertAll(() -> GameDataValidator.validateOrder(0));
        assertAll(() -> GameDataValidator.validateOrder(1));
        assertAll(() -> GameDataValidator.validateOrder(2));
        assertThatIllegalArgumentException().isThrownBy(
                () -> GameDataValidator.validateOrder(-1)
        );
        assertThatIllegalArgumentException().isThrownBy(
                () -> GameDataValidator.validateOrder(3)
        );
    }

    @Test
    void Number_검증_테스트() {
        assertAll(() -> GameDataValidator.validateNumber(1));
        assertAll(() -> GameDataValidator.validateNumber(5));
        assertAll(() -> GameDataValidator.validateNumber(9));
        assertThatIllegalArgumentException().isThrownBy(
                () -> GameDataValidator.validateNumber(0)
        );
        assertThatIllegalArgumentException().isThrownBy(
                () -> GameDataValidator.validateNumber(10)
        );
    }

    @Test
    void Pitching_Count_검증_테스트() {
        assertAll(() -> GameDataValidator.validatePitchingCount(3));
        assertThatIllegalArgumentException().isThrownBy(
                () -> GameDataValidator.validatePitchingCount(2)
        );
        assertThatIllegalArgumentException().isThrownBy(
                () -> GameDataValidator.validatePitchingCount(4)
        );
    }
}
