package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballNumberTest {
    @Test
    @DisplayName("숫자 객체 생성")
    void test() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        // when
        BaseballNumber baseballNumber = new BaseballNumber(numbers);

        // then
        assertThat(baseballNumber.get(0)).isEqualTo(1);
        assertThat(baseballNumber.get(1)).isEqualTo(2);
        assertThat(baseballNumber.get(2)).isEqualTo(3);

        assertThat(baseballNumber.size()).isEqualTo(3);

        assertThat(baseballNumber.contains(3)).isTrue();
        assertThat(baseballNumber.contains(4)).isFalse();
    }
}
