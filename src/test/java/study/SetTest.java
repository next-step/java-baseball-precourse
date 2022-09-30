package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * author : hyeongju
 * date : 2022.09.27
 * description : Junit 학습을 위한 Set Cikkection 테스트 클래스
 */
public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("set의 크기를 확인하는 테스트")
    @Test
    void setSizeTest(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("숫자가 모두 포함되어있는지 테스트")
    @Test
    void containsTest(){
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("숫자가 모두 포함되어있는지 테스트. (중복 코드 제거)")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsTest2(int input){
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("포함되었는지 테스트. true, false 도 함께 return")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsTest3(int el, boolean expected){
        assertThat(numbers.contains(el)).isEqualTo(expected);
    }

}
