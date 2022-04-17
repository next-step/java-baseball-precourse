package baseball.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputUtilTest {

    @Test
    @DisplayName("숫자배열 변환 테스트")
    void convertToIntegerListTest() {
        List<Integer> integers = InputUtil.convertToIntegerList("123");
        assertThat(integers).isEqualTo(Arrays.asList(1,2,3));
    }
}