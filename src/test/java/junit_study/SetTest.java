package junit_study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    @DisplayName("SET_요구사항_1")
    void size_check(){
         int setSize = numbers.size();
         assertThat(setSize).isEqualTo(3);
    }

    @DisplayName("SET_요구사항_2")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void set_values_check(int number){
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("SET_요구사항_3")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true","4:false","5:false"}, delimiter = ':')
    void set_values_all_check(int number, boolean expected){
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}