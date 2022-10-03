package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
  @DisplayName("요구사항 1 - size() 메소드를 활용해 Set 크기를 확인 (중복 확인) ")
  void setSizeTest() {

    assertThat(numbers.size()).isEqualTo(3);
  }


  @DisplayName("요구사항 2 - contains() 메소드와 ParameterizedTest 활용해 1, 2, 3의 값이 존재하는지를 확인 ")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  void setContainTest(int testValues) {
    assertTrue(numbers.contains(testValues));
  }


  @DisplayName("요구사항 3 - contains() 메소드와 CsvSource 활용해 포함되면 true, 없으면 false 가 반환 되는지 확인 ")
  @ParameterizedTest
  @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"},delimiter = ':')
  void isSetContainTest(int value, boolean result) {
    assertThat(numbers.contains(value)).isEqualTo(result);
  }

}
