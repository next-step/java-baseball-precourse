package baseball.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
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
    void Number_List_검증_테스트() {
        assertAll(() -> GameDataValidator.validateNumberList(
                Arrays.asList(1, 2, 3)
        ));
        assertThatIllegalArgumentException().isThrownBy(
                () -> GameDataValidator.validateNumberList(
                        Arrays.asList(1, 2, 3, 4)
                )
        );
        assertThatIllegalArgumentException().isThrownBy(
                () -> GameDataValidator.validateNumberList(
                        Arrays.asList(9, 9, 9)
                )
        );
        assertThatIllegalArgumentException().isThrownBy(
                () -> GameDataValidator.validateNumberList(
                        Arrays.asList(9, 9, 8)
                )
        );
        assertThatIllegalArgumentException().isThrownBy(
                () -> GameDataValidator.validateNumberList(
                        Arrays.asList(0, 9, 8)
                )
        );
    }
}
