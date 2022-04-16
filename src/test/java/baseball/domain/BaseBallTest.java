package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseBallTest {
    @DisplayName("볼 개수를 적게 전달")
    @ParameterizedTest
    @ValueSource(strings = {"12", "23", "45", "98"})
    void lessBall(String numberString) {
        assertThatThrownBy(() -> new BaseBall(stringToIntegerList(numberString)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("볼 개수를 많게 전달")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "2345", "4567", "9812"})
    void moreBall(String numberString) {
        assertThatThrownBy(() -> new BaseBall(stringToIntegerList(numberString)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("개수는 일치하지만 중복 숫자 있는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"122", "233", "455", "991"})
    void duplicateBall(String numberString) {
        assertThatThrownBy(() -> new BaseBall(stringToIntegerList(numberString)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성 조건을 만족")
    @ParameterizedTest
    @ValueSource(strings = {"123", "234", "456", "981"})
    void equalsCondition(String numberString) {
        BaseBall baseBall = new BaseBall(stringToIntegerList(numberString));
        assertThat(baseBall.toString()).isEqualTo(numberString);
    }

    private List<Integer> stringToIntegerList(String numberString) {
        List<Integer> numbers = new ArrayList<>();
        for (String s: numberString.split("")) {
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }
}