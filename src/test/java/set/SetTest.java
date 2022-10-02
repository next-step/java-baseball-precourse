package set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SetTest {

    private Set<Integer> numbers;
    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void firstRequirements(){
        assertThat(numbers).hasSize(numbers.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void secondRequirements(int input){
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1","2:2","3:3","4:4","5:5"}, delimiter = ':')
    boolean thirdRequirements(int key,int value){
        Assertions.assertEquals(key,value);
        return numbers.contains(value);
    }

}
