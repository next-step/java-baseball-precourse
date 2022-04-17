package study;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CollectionTest {

    @Test
    @DisplayName("콜렉션테스트-set Size 크기 확인")
    void 셋콜렉션테스트1() {
        Set<String> strings = new HashSet<String>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        assertThat(strings.size()).isEqualTo(3);
    }

    @DisplayName("콜렉센테스트- 요구사항 2 " +
            "JUnit의 ParameterizedTest를 활용해 중복 코드를 제거")
    @ParameterizedTest
    @ValueSource(strings = {"1","2","3","4"})
    void 셋콜렉션테스트2(String param) {
        assertTrue(StringUtils.isNotBlank(param));
    }

    @DisplayName("콜렉션테스트- 요구사항 3 " +
            "1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void 셋콜렉션테스트3(String param, boolean expected) {
        assertThat(StringUtils.isNotBlank(param)).isEqualTo(expected);//4,5 false
    }
}