package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class FacilitatorTest {
    private Facilitator facilitator;

    @BeforeEach
    void setUp() {
        facilitator = new Facilitator();
    }

    @DisplayName("서로다른 3개의 숫자 생성")
    @Test
    void numbersGenerator() {
        List<Integer> comNumbers = facilitator.numbersGenerator();
        assertThat(comNumbers.size()).isEqualTo(3);
        assertThat(comNumbers.stream().distinct().count()).isEqualTo(3);
    }

    @DisplayName("입력 받은 문자열을 숫자 리스트로 변경")
    @ValueSource(strings = {"123"})
    @ParameterizedTest
    void splitNumbers(final String numbersStr) {
        List<Integer> playerNumbers = facilitator.splitNumbers(numbersStr);
        assertThat(playerNumbers.size()).isEqualTo(3);
        assertThat(playerNumbers.stream().distinct().count()).isEqualTo(3);
    }

    @DisplayName("플레이어가 잘못 입력")
    @ValueSource(strings = {"a23"})
    @ParameterizedTest
    void fail_splitNumbers(final String numbersStr) {
        assertThatThrownBy(() -> facilitator.splitNumbers(numbersStr))
                .isInstanceOf(IllegalArgumentException.class);
    }
}