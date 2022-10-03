package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("String class 학습 테스트")
class StringTest {
    //@ParameterizedTest
    //@MethodSource

    @Test
    @DisplayName("요구사항1-1 1,2 split 분리 후 테스트")
    void splitTest_1(){
        //given
        final String delimiter = ",";
        final String given = "1,2";
        final String[] expected = {"1","2"};

        //when
        String[] actual = given.split(delimiter);

        //then
        assertThat(actual).contains(expected);
    }

    @Test
    @DisplayName("요구사항1-2 1, split 후 1만 포함 여부 테스트")
    void splitTest_2(){
        //given
        final String delimiter = ",";
        final String given = "1,";
        final String expected = "1";

        //when
        String[] actual = given.split(delimiter);

        //then
        assertThat(actual).containsExactly(expected);
    }



    @Test
    @DisplayName("요구사항2 (1,2) 값을 substring 사용하여 () 제거 후 1,2 반환 테스트")
    void substringTest(){
        //given
        final String given = "(1,2)";
        final String expected = "1,2";
        final String startBracket = "(";
        final String endBracket = ")";

        //when
        String actual = given.substring(given.indexOf(startBracket)+1, given.indexOf(endBracket));

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("abc 문자열이 주어졌을때 charAt 사용하여 특정 위치 문자 확인")
    void charAtTest_1(){
        //given
        final String given = "abc";
        final char[] expected = {'a','b','c'};

        //when
        //then
        for(int i=0; i<given.length(); i++){
            assertThat(given.charAt(i)).isEqualTo(expected[i]);
        }

    }

    @Test
    @DisplayName("범위 벗어났을 경우 StringIndexOutOfBoundsException 발생 테스트")
    void charAtTest_2(){
        //given
        final String given = "abc";

        //when
        //then
        assertThatThrownBy(
                () -> {
                    given.charAt(given.length());
                }
        )
        .isInstanceOf(IndexOutOfBoundsException.class)
        .hasMessageContaining("out of range");
    }
}