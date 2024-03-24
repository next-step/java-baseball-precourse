package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Baseball 클래스 테스트")
public class BaseballTest {
    @Test
    @DisplayName("Baseball 생성자 테스트 - 가능한 숫자 입력")
    public void testValidBaseballNumbers() {
        Baseball baseball = new Baseball("123");
        assertThat(baseball.getBaseball()).containsExactly(1, 2, 3);
        assertThat(baseball.getNumber(0)).isEqualTo(1);
        assertThat(baseball.contains(2)).isTrue();
        assertThat(baseball.contains(9)).isFalse();
    }

    @Test
    @DisplayName("Baseball 생성자 테스트 - 불가능한 숫자 입력(세 자리 이외의 수)")
    public void testInvalidBaseballNumbers() {
        assertThrows(IllegalArgumentException.class, () -> new Baseball("12"));
        assertThrows(IllegalArgumentException.class, () -> new Baseball("1234"));
    }
    @Test
    @DisplayName("Baseball 생성자 테스트 - 불가능한 숫자 입력(범위 이외의 값)")
    public void testBaseballNumbersOnlyNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Baseball("abc"));
        assertThrows(IllegalArgumentException.class, () -> new Baseball("1a2"));
        assertThrows(IllegalArgumentException.class, () -> new Baseball("012"));
    }

    @Test
    @DisplayName("Baseball 생성자 테스트 - 불가능한 숫자 입력(중복된 숫자)")
    public void testBaseballNumbersDuplicate() {
        assertThrows(IllegalArgumentException.class, () -> new Baseball("112"));
    }


}
