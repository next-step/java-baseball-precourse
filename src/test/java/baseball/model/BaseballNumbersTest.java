package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class BaseballNumbersTest {

    @Test
    void 숫자_리스트의_크기는_3_성공() {
        List<Integer> numbers = new ArrayList<>(3);

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        BaseballNumbers baseballNumbers = new BaseballNumbers(numbers);

        assertThat(baseballNumbers).isNotNull();
    }

    @Test
    void 숫자_리스트의_크기는_3_실패() {
        List<Integer> numbers = new ArrayList<>(3);

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        assertThatThrownBy(() -> {
            new BaseballNumbers(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_리스트_중복_숫자_실패() {
        List<Integer> numbers = new ArrayList<>(3);

        numbers.add(1);
        numbers.add(1);
        numbers.add(3);

        assertThatThrownBy(() -> {
            new BaseballNumbers(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}