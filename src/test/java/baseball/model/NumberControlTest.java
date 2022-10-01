package baseball.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumberControlTest {

    @Test
    void 숫자의_총_자리수는_9보다_클_수_없음() {
        assertThatThrownBy(() -> {
            new NumberControl(10, 1, 2);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("numberTotalLength cannot be greater than 9.");
    }

    @Test
    void 숫자의_총_자리수는_1보다_작을_수_없음() {
        assertThatThrownBy(() -> {
            new NumberControl(0, 1, 2);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("numberTotalLength cannot be less than 1.");
    }

    @Test
    void 각_자리수에_들어갈_수_있는_가장_작은_숫자는_각_자리수에_들어갈_수_있는_가장_큰_수보다_클_수_없음() {
        assertThatThrownBy(() -> {
            new NumberControl(5, 4, 2);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("startInclusive cannot be greater than endInclusive.");
    }

    @Test
    void 각_자리수에_들어갈_수_있는_가장_작은_숫자는_9보다_클_수_없음() {
        assertThatThrownBy(() -> {
            new NumberControl(4, 10, 5);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("startInclusive cannot be greater then 9.");
    }

    @Test
    void 각_자리수에_들어갈_수_있는_가장_작은_숫자는_1보다_작을_수_없음() {
        assertThatThrownBy(() -> {
            new NumberControl(4, 0, 5);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("startInclusive cannot be less then 1.");
    }

    @Test
    void 각_자리수에_들어갈_수_있는_가장_큰_숫자는_9보다_클_수_없음() {
        assertThatThrownBy(() -> {
            new NumberControl(4, 7, 10);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("endInclusive cannot be greater then 9.");
    }

    @Test
    void 각_자리수에_들어갈_수_있는_가장_큰_숫자는_1보다_작을_수_없음() {
        assertThatThrownBy(() -> {
            new NumberControl(4, 3, 0);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("endInclusive cannot be less then 1.");
    }

    @Test
    void numberControll_정상_생성_테스트() {
        NumberControl numberControl = new NumberControl(4, 3, 8);
        assertThat(numberControl.getNumberTotalLength()).isEqualTo(4);
        assertThat(numberControl.getStartInclusive()).isEqualTo(3);
        assertThat(numberControl.getEndInclusive()).isEqualTo(8);
    }
}