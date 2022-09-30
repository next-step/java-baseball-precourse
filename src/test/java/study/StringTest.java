package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * author : hyeongju
 * date : 2022.09.27
 * description : Junit 학습을 위한 String 테스트 클래스
 */
public class StringTest {

    /**
     * 1과 2로 분리되는지 테스트
     */
    @Test
    void splitTest(){
        String str = "1,2";
        String[] split = str.split(",");

        assertThat(split)
                .contains("1")
                .contains("2");
    }

    /**
     * 1만을 포함하는 배열이 반환하는지 테스트
     */
    @Test
    void splitOneTest(){
        String str = "1";
        String[] split = str.split(",");

        assertThat(split).containsExactly("1");
    }

    /**
     * "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 "1,2" 반환 하는지 테스트
     */
    @Test
    void subStringAndSplitTest(){
        String str = "(1,2)";
        String substr = str.substring(1, 4);

        assertThat(substr).isEqualTo("1,2");
    }

    /**
     * "abc" 값이 주어졌을 때 String 의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트
     */
    @Test
    @DisplayName("존재하지 않는 index 접근시 StringIndexOutOfBoundsException 발생 테스트")
    void test3(){
        String str = "abc";
        int index = 5;

        assertThatThrownBy(() -> {
            str.charAt(index);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: ")
                .hasMessageContaining(String.valueOf(index));
    }

}


