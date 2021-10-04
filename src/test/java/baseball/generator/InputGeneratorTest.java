package baseball.generator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputGeneratorTest {

    @Test
    @DisplayName("문자열을 정수 리스트로 반환")
    void convertToIntegerList() {
        //given
        final String input = "146";
        //when
        final List<Integer> result = InputGenerator.convertToIntegerList(input);
        //then
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(0).intValue()).isEqualTo(1);
        assertThat(result.get(1).intValue()).isEqualTo(4);
        assertThat(result.get(2).intValue()).isEqualTo(6);

    }
}