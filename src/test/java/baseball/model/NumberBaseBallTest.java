package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.code.ValidationCode;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberBaseBallTest {

    @DisplayName("입력받은 숫자 길이 확인")
    @ParameterizedTest
    @ValueSource(strings = { "456", "123", "927" })
    void lengthCheckTest(String numberBaseBall) {
        assertThat(numberBaseBall.length()).isEqualTo(3);
    }

    @DisplayName("입력받은 숫자 길이 확인 예외")
    @Test
    void lengthCheckTest() {
        assertThatThrownBy(() -> new NumberBaseBall("123456789"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ValidationCode.LENGTH.getMessage());
    }

    @DisplayName("입력받은 숫자 여부 확인")
    @ParameterizedTest
    @ValueSource(strings = { "731", "159", "549" })
    void numberCheckTest(String numberBaseBall) {
        assertThat(numberBaseBall.matches("[0-9]+")).isTrue();
    }

    @DisplayName("입력받은 숫자 여부 확인 예외")
    @Test
    void numberCheckTest() {
        assertThatThrownBy(() -> new NumberBaseBall("ABC"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ValidationCode.NUMBER.getMessage());
    }

    @DisplayName("입력받은 숫자 중복 확인")
    @ParameterizedTest
    @ValueSource(strings = { "154", "791", "623" })
    void overlapCheckTest(String numberBaseBall) {
        Set<Character> set = new HashSet<>();

        for (char c : numberBaseBall.toCharArray()) {
            set.add(c);
        }

        assertThat(set.size()).isEqualTo(3);
    }

    @DisplayName("입력받은 숫자 중복 확인 예외")
    @Test
    void overlapCheckTest() {
        assertThatThrownBy(() -> new NumberBaseBall("111"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ValidationCode.OVERLAP.getMessage());
    }

    @DisplayName("contians true 케이스")
    @ParameterizedTest
    @ValueSource(ints = { 2, 7, 9 })
    void containsFalseTest(int number) {
        NumberBaseBall numberBaseBall = new NumberBaseBall("927");

        assertThat(numberBaseBall.contains(number)).isTrue();
    }

    @DisplayName("contians false 케이스")
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 3, 4, 5, 6, 8 })
    void containsTrueTest(int number) {
        NumberBaseBall numberBaseBall = new NumberBaseBall("927");

        assertThat(numberBaseBall.contains(number)).isFalse();
    }

    @DisplayName("get isEquals 케이스")
    @Test
    void getTest() {
        NumberBaseBall numberBaseBall = new NumberBaseBall("927");

        assertThat(numberBaseBall.get(0)).isEqualTo(9);
        assertThat(numberBaseBall.get(1)).isEqualTo(2);
        assertThat(numberBaseBall.get(2)).isEqualTo(7);
    }
}
