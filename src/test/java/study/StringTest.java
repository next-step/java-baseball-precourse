package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    public void 요구사항1(){
        //given
        String strA = "1,2";
        //when
        String[] arrayA = strA.split(",");
        //then
        assertThat(arrayA).contains("1","2");

        //given
        String strB = "1";
        //when
        String[] arrayB = strB.split(",");
        //then
        assertThat(arrayB).containsExactly("1");
    }

    @Test
    public void 요구사항2(){
        //given
        String a = "(1,2)";
        //when
        String strA = a.substring(a.indexOf("(")+1, a.indexOf(")"));
        //then
        assertThat(strA).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 처리")
    public void 요구사항3(){
        //given
        String str = "abc";
        //then
        assertThat(str.charAt(0)).isEqualTo('a');

        assertThatThrownBy(() -> {str.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
