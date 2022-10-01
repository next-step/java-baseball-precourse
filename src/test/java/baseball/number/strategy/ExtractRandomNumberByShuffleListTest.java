package baseball.number.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.number.NumberConstant.MAXIMUM_NUMBER;
import static baseball.number.NumberConstant.MINIMUM_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ExtractRandomNumberByShuffleListTest {
    private List<Integer> integerList;

    @BeforeEach
    void setUp() {
        ExtractNumberStrategy extractNumberStrategy = new ExtractRandomNumberByShuffleList();
        integerList = extractNumberStrategy.extract();
    }

    @DisplayName("숫자를 랜덤하게 3개를 생성하고, 해당 숫자가 중복이 없는지 확인한다.")
    @Test
    void extractCheckDuplication() {
        Set<Integer> integerSet = new HashSet<>(integerList);
        assertThat(integerSet).hasSize(3);
    }

    @DisplayName("랜덤하게 생성한 숫자가 1~9 사이의 값인지 확인한다.")
    @Test
    void extractValidRangeOfNumbers() {
        assertAll(
                () -> assertThat(integerList.get(0)).isBetween(MINIMUM_NUMBER, MAXIMUM_NUMBER),
                () -> assertThat(integerList.get(1)).isBetween(MINIMUM_NUMBER, MAXIMUM_NUMBER),
                () -> assertThat(integerList.get(2)).isBetween(MINIMUM_NUMBER, MAXIMUM_NUMBER)
        );
    }
}