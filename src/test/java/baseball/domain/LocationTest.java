package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LocationTest {

    @DisplayName("위치는 1에서 3사이의 값을 갖는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void numberRange(int location) {
        assertThat(Location.from(location)).isInstanceOf(Location.class);
    }

    @DisplayName("위치 값으로 1에서 3사이 이외 값을 입력하면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-2, -1, 0, 4, 5, 6})
    void numberOutOfRange(int location) {
        assertThatThrownBy(() -> Location.from(location)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("같은 위치값이면 참이다.")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    void numberSame(int input1, int input2) {
        Location location1 = Location.from(input1);
        Location location2 = Location.from(input2);
        assertThat(location1).isEqualTo(location2);
    }

    @DisplayName("위치가 다르면 거짓이다.")
    @ParameterizedTest
    @CsvSource(value = {"1:2", "3:1", "2:3"}, delimiter = ':')
    void numberDifferent(int input1, int input2) {
        Location location1 = Location.from(input1);
        Location location2 = Location.from(input2);
        assertThat(location1).isNotEqualTo(location2);
    }

}
