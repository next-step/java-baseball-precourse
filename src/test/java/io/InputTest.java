package io;

import static io.Input.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputTest {

    @Test
    @DisplayName("1에서 9까지의 서로 다른 3개의 숫자 입력")
    void validateAndParse_case1() {
        // given
        Input input = new Input();

        // when, validateGuessAndParse를 public으로 설정 후 테스트
//        List<Integer> inputNumbers = validateGuessAndParse("123");

        // then
//        assertThat(inputNumbers).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("문자 입력")
    void validateAndParse_case2() {
        // given
        Input input = new Input();

        // when, then, validateGuessAndParse를 public으로 설정 후 테스트
//        assertThatThrownBy(() -> validateGuessAndParse("가나다")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0 입력")
    void validateAndParse_case3() {
        // given
        Input input = new Input();

        // when, then, validateGuessAndParse를 public으로 설정 후 테스트
//        assertThatThrownBy(() -> validateGuessAndParse("105")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("3개가 아닌 숫자 입력")
    void validateAndParse_case4() {
        // given
        Input input = new Input();

        // when, then, validateGuessAndParse를 public으로 설정 후 테스트
//        assertThatThrownBy(() -> validateGuessAndParse("1234")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("같은 숫자 입력")
    void validateAndParse_case5() {
        // given
        Input input = new Input();

        // when, then, validateGuessAndParse를 public으로 설정 후 테스트
//        assertThatThrownBy(() -> validateGuessAndParse("112")).isInstanceOf(IllegalArgumentException.class);
    }
}