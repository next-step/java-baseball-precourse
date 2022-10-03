package junitstudy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringTest {

    @Test
    void splitTest1(){
        String str = "1,2";
        String[] split = str.split(",");
        assertThat(split).containsExactly("1","2");
    }

    @Test
    void splitTest2(){
        String str = "1";
        String[] split = str.split(",");
        assertThat(split).contains("1");
    }

    @Test
    void removeBracketTest(){
        String str = "(1,2)";
        String s = str.substring(str.indexOf("(")+1, str.indexOf(")"));
        assertThat(s).isEqualTo("1,2");
    }

    @Test
    void findIndexCharTest(){
        String str = "i am developer";
        char findChr = str.charAt(3);
        assertThat(findChr).isEqualTo('m');
    }

    @Test
    @DisplayName("특정 위치 문자 찾기 - 인덱스 예외 테스트")
    void findIndexCharExceptionTest(){
        assertThatThrownBy(()->{
            "i am developer".charAt(100);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}