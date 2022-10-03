package baseball.model.player;

import static baseball.constant.BaseballStringEnum.INVALID_DIGIT_NUMBER;
import static baseball.constant.BaseballStringEnum.NUMBER_INCLUDES_DUPLICATE;
import static baseball.constant.BaseballStringEnum.NUMBER_INCLUDES_DUPLICATE_OVER_3_DIGIT;
import static baseball.constant.BaseballStringEnum.STRING_WITH_LENGTH_ONE;
import static baseball.constant.BaseballStringEnum.STRING_WITH_LENGTH_TWO;
import static baseball.constant.BaseballStringEnum.VALID_NUMBER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    @DisplayName("number which is not 3-digit number should result to get False")
    void validateInputFalse() {
        Player unit = new Player();
        assertThat(unit.validateInput(INVALID_DIGIT_NUMBER.label)).isFalse();
    }

    @Test
    @DisplayName("number which is 3-digit number should result to get True")
    void validateInputSuccess() {
        Player unit = new Player();
        assertThat(unit.validateInput(VALID_NUMBER.label)).isTrue();
    }

    @Test
    @DisplayName("setting number which is not 3-digit to model should result IllegalArgumentException")
    void setInputNumber() {
        Player unit = new Player();
        assertThrows(IllegalArgumentException.class, () -> unit.setInputNumber(INVALID_DIGIT_NUMBER.label));
    }

    @Test
    @DisplayName("should return true with ${NUMBER_INCLUDES_DUPLICATE}")
    void containDuplicate_true() {
        Player unit = new Player();
        assertThat(unit.checkContainDuplication(NUMBER_INCLUDES_DUPLICATE.label)).isTrue();
    }

    @Test
    @DisplayName("should return false with ${VALID_NUMBER}")
    void containDuplicate_false() {
        Player unit = new Player();
        assertThat(unit.checkContainDuplication(VALID_NUMBER.label)).isFalse();
    }

    @Test
    void containDuplicates() {
        Player unit = new Player();
        assertThat(unit.checkContainDuplication(NUMBER_INCLUDES_DUPLICATE_OVER_3_DIGIT.label)).isTrue();
    }

    @Test
    @DisplayName("pass a string with length 1 then should return true")
    void isTargetLength() {
        Player unit = new Player();
        assertThat(unit.isTargetLength(STRING_WITH_LENGTH_ONE.label)).isTrue();
    }

    @Test
    @DisplayName("pass a string with length 2 then should return false")
    void isTargetLength_false() {
        Player unit = new Player();
        assertThat(unit.isTargetLength(STRING_WITH_LENGTH_TWO.label)).isFalse();
    }
}