package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DataConverterTest {

    private String source;

    @BeforeEach()
    void setUp() {
        source = "019";
    }

    @Test()
    @DisplayName("문자열을 List<Integer> 형태로 변환")
    void stringToIntegerList() {
        // when
        List<Integer> result = DataConverter.stringToIntegerList(source);

        // then
        assertThat(result.size()).isEqualTo(source.length());
        assertThat(result.contains(0)).isTrue();
        assertThat(result.contains(1)).isTrue();
        assertThat(result.contains(9)).isTrue();
    }

    @Test
    @DisplayName("문자열을 Set<Integer> 형태로 변환")
    void stringToIntegerSet() {
        // when
        Set<Integer> result = DataConverter.stringToIntegerSet(source);

        // then
        assertThat(result.size()).isEqualTo(source.length());
        assertThat(result.contains(0)).isTrue();
        assertThat(result.contains(1)).isTrue();
        assertThat(result.contains(9)).isTrue();
    }

    @Test
    @DisplayName("단일 문자열을 int 형태로 변환")
    void stringToDigit() {
        // given
        String source = "1";

        // when
        int result = DataConverter.stringToDigit(source);

        // then
        assertThat(result).isEqualTo(1);

    }

    @Test
    @DisplayName("Set<Integer> 타입을 List<Integer> 타입으로 변환")
    void setToList() {
        // given
        Set<Integer> source = new LinkedHashSet<>();
        source.add(1);
        source.add(2);
        source.add(3);

        // when
        List<Integer> result = DataConverter.setToList(source);

        // then
        assertThat(result.contains(1)).isTrue();
        assertThat(result.contains(2)).isTrue();
        assertThat(result.contains(3)).isTrue();
    }
}