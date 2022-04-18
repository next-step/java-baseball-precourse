package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

public class junitSetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setNumbers(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
    }

    @Test
    void checkSetSize(){
        Assertions.assertThat(numbers.size()).isEqualTo(5);
    }

    @Test
    void contains(){
        Assertions.assertThat(numbers.contains(1)).isTrue();
        Assertions.assertThat(numbers.contains(5)).isTrue();
        Assertions.assertThat(numbers.contains(10)).isFalse();
    }

    @Test
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "10:false"}, delimiter = ':')
    void userInputContains(int number, boolean result){
        System.out.println(number + "" + result);
        Assertions.assertThat(numbers.contains(number)).isEqualTo(result);
    }
}
