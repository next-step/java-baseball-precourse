package baseball.type;

import static baseball.type.ErrorMessageType.LESS_THAN_START_INCLUSIVE;
import static baseball.type.NumberRangeType.isNumberRangeType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberRangeTypeTest {

    @ParameterizedTest
    @ValueSource(strings = {"014", "104", "140"})
    @DisplayName("시작 범위의 수보다 입력한 수가 작으면 IllegalArgumentException 예외가 발생한다.")
    void numberRangeType_notAllowLessThanStartInclusive(String input) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> {
                for (char charAt : input.toCharArray()) {
                    isNumberRangeType(Character.getNumericValue(charAt));
                }
            })
            .withMessageContaining(LESS_THAN_START_INCLUSIVE.getMessage());
    }
}