package junit_study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {

    @Test
    @DisplayName("문자열_나누기_테스트")
    void split_string(){
        String str = "1,2";
        assertThat(str.split(",")).contains("1","2");
        str = "1";
        assertThat(str.split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("괄호_삭제_테스트")
    void remove_bracket(){
        String str = "(1,2)";
        assertThat(str.substring(str.indexOf("(")+1,str.indexOf(")"))).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정_인덱스_문자_가져오기_테스트")
    void chatAt_str(){
        String str = "abc";
        assertEquals(str.charAt(1), 'b');
    }

    @Test
    @DisplayName("특정_인덱스_문자_가져오기_예외_테스트")
    void chatAt_str_exception(){
        String str = "abc";
        assertThatThrownBy(() -> str.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
