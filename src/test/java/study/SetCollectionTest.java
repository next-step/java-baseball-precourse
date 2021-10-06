package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SetCollectionTest {
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
  @DisplayName("Set의 size() 메소드 활용하여 Set 크기 확인")
  void size() {
    int expectedSize = 3;
    int wrongCaseSize = 4;

    assertThat(numbers.size()).isEqualTo(expectedSize);
    assertThat(numbers.size()).isNotEqualTo(wrongCaseSize);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  @DisplayName("Set의 contains() 메소드 활용하여 파라미터 값 존재 여부 확인 및 중복코드 제거")
  void contains(int number) {
    // duplicate code
    assertThat(numbers.contains(1)).isTrue();
    assertThat(numbers.contains(2)).isTrue();
    assertThat(numbers.contains(3)).isTrue();

    // parameterized number
    assertThat(numbers.contains(number)).isTrue();
  }

  @ParameterizedTest
  @CsvSource(value = {"1:true", "4:false", "5:false"}, delimiter = ':')
  @DisplayName("Set의 contains() 메소드 활용하여 true/false 테스트를 하나의 test case로 구현")
  void containsTrueFalseTestCase(int number, boolean isCorrect) {
    assertThat(numbers.contains(number)).isEqualTo(isCorrect);
  }
}
