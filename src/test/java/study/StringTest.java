package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void 요구사항1_문자열split() {
        String str1 = "1,2";
        String str2 = "1";

        String[] str1_split = str1.split(",");
        String[] str2_split = str2.split(",");

        assertThat(str1_split).contains("1", "2").containsExactly("1", "2");
        assertThat(str2_split).contains("1").containsExactly("1");
    }

    @Test
    void 요구사항2_괄호제거() {
        String str1 = "(1,2)";

        String str1_number = str1.substring(1, str1.length()-1);

        assertThat(str1_number).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String의 charAt() 메소드로 특정위치 문자열가져오기")
   void 요구사항3_charAt() {
        String str1 = "abc";

//        assertThatThrownBy(() -> {
//
//        }).isInstanceOf(IndexOutOfBoundsException.class)
//                .hasMessageContaining("Index:")
    }
}
