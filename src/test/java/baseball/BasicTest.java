package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.util.CommonUtils;

public class BasicTest {
	private Set<Integer> numbers;
	
    @BeforeEach
    void setUp() {
    	numbers = new HashSet<Integer>();
    	
    	numbers.add(1);
    	numbers.add(2);
    	numbers.add(3);
    	numbers.add(4);
    }

    @Test
    void JUNIT_기본테스트1() {
    	String str = "122";
    	String[] split = str.split("");
    	
    	String[] expected = {
    			"1","2","2"
    	} ; 
    	
    	assertThat(split).contains("1");
    	assertArrayEquals(expected,split);
    }
    
    @Test
    void JUNIT_기본테스트2() {
    	assertThat(numbers.contains(1)).isTrue();
    	assertThat(numbers.contains(2)).isTrue();
    	assertThat(numbers.contains(3)).isTrue();
    	assertThat(numbers.contains(4)).isTrue();
    }
    
    // blank 테스트
    @ParameterizedTest
    @ValueSource(strings = {""," "})
    void JUNIT_기본테스트3(String input) {
    	assertTrue(CommonUtils.isNullOrEmpty(input));
    }
    
    // csv 
    @ParameterizedTest
    @CsvSource(value = {"test,test", "Kim,kim"}, delimiter = ',')
    void JUNIT_기본테스트4(String input, String expected) {
    	String actual = input.toLowerCase();
    	assertEquals(actual, expected);
    }
}
