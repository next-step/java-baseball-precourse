package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

    @Test
    @DisplayName("정상적으로 분리된 배열이 반환되는지 확인")
    void checkMultiValueSplit() {
        // given
        String offerStr = "1,2";
        String separator = ",";

        // when
        String[] result = offerStr.split(separator);

        // then
        assertAll(
                () -> assertThat(result).isNotEmpty(),
                () -> assertThat(result).isInstanceOf(String[].class),
                () -> assertThat(result).containsExactly("1", "2")
        );
    }
}
