package study;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("스플릿테스트")
    void 스트링클래스테스트1() {
        String[] splitArr = "1,2".split(",");
        assertThat(splitArr)
                .containsExactly("1","2");
        String[] splitArr2 = "1".split(",");//1만 split시 split 체크
        assertThat(splitArr2)
                .containsExactly("1");
    }

    @Test
    @DisplayName("서브스트링테스트")
    void 스트링클래스테스트2() {
        String subStr = "(1,2)".substring(1,4);
        assertThat(subStr)
                .isEqualTo("1,2");
    }

    @Test
    @DisplayName("인덱스익셉션테스트")
    void 스트링클래스테스트3() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    "abc".charAt(4);
                }).withMessageContaining("Index: 4, Size: 4");
    }
}
