package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;

import static baseball.domain.PickNumbers.*;
import static nextstep.utils.Randoms.pickNumberInRange;
import static org.assertj.core.api.Assertions.*;

class PickNumbersTest {

    @BeforeEach
    void beforeEach() {
        makePickNumbers();
    }

    @Test
    @DisplayName("최초에 생성된 랜덤값은 변하지 않는다")
    void onlyOnceMakePickNumbersTest() {
        LinkedHashSet<Integer> first = getPickNumbersSet();

        makePickNumbers();
        LinkedHashSet<Integer> second = getPickNumbersSet();

        assertThat(first).isEqualTo(second);
    }

    @Test
    @DisplayName("랜덤 값의 최소값, 최대값은 게임 설정에 따른다")
    void addPickNumber() {
        int pickNumber = pickNumberInRange(GameConfig.MIN_NUMBER.getValue(), GameConfig.MAX_NUMBER.getValue());
        assertThat(pickNumber).isGreaterThanOrEqualTo(GameConfig.MIN_NUMBER.getValue()).isLessThanOrEqualTo(GameConfig.MAX_NUMBER.getValue());
    }

    @Test
    @DisplayName("랜덤값 생성 시 스택오버플로우가 터질 수 있는 경우")
    void validateMaxValueTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    pickNumberInRange(Integer.MIN_VALUE, Integer.MAX_VALUE);
                }).withMessageMatching("끝값이 너무 큽니다. \\(스택 오버플로우 발생이 가능합니다\\)");
    }

    @Test
    @DisplayName("랜덤값 생성 시 잘못된 범위가 입력되는 경우")
    void validateRangeTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    pickNumberInRange(9, 1);
                }).withMessageMatching("startInclusive가 endInclusive보다 클 수 없습니다.");
    }

    @Test
    @DisplayName("랜덤값을 삭제한다")
    void pickNumbersClearTest() {
        LinkedHashSet<Integer> set = getPickNumbersSet();
        assertThat(set.size()).isEqualTo(GameConfig.PICK_NUMBER_SIZE.getValue());

        pickNumbersClear();
        assertThat(set).isEmpty();
    }
}