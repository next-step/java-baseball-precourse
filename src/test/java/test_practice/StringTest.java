package test_practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    void stringTest1(){
        String[] arr = "1,2".split(",");
        assertThat(arr).containsExactly("1", "2");

        arr = "1,".split(",");
        assertThat(arr).hasSize(1).containsExactly("1");
    }

    @Test
    void stringTest2(){
        String result = "(1,2)".substring(1,4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test @DisplayName("범위를 벗어난 인덱스 예외 발생 테스트")
    void stringTest3(){
        String str = "abc";

        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');
        //        assertThrows(StringIndexOutOfBoundsException.class, () -> str.charAt(3));
        //        assertThatThrownBy(() -> {str.charAt(3);}).isInstanceOf(StringIndexOutOfBoundsException.class);
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {str.charAt(3);}).withMessageMatching("String index out of range: 3");
    }


}
