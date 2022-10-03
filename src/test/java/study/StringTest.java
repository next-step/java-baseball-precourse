package study;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class StringTest {

  @Test
  @DisplayName("요구사항 1 - 1,2  ,로 split 분리 테스트")
  void arraySplitTest() {

    String[] values = "1,2".split(",");
    assertThat(values).contains("1", "2");
  }


  @Test
  @DisplayName("요구사항 1 - 1  ,로 split 분리 테스트")
  void StringSplitTest() {
    String[] values = "1".split(",");
    assertThat(values).containsExactly("1");
  }


  @Test
  @DisplayName("요구사항 2 - () 을 제거하고 1,2를 반환")
  void subStringTest() {

    String value = "(1,2)";
    String substring = value.substring(1, value.length()-1);
    assertThat(substring).isEqualTo("1,2");
  }


  @Test
  @DisplayName("요구사항 3 - abc 값이 주어졌을 때 charAt() 메소드를 활용 StringIndexOutOfBoundsException이 발생하는 부분에 대한 assertThatThrownBy 학습")
  void charAtTest() {

    String value = "abc";
    int index = 10;
    assertThatThrownBy(() -> value.charAt(index)).isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range: %d", index);
  }

  @Test
  @DisplayName("요구사항 3 - abc 값이 주어졌을 때 charAt() 메소드를 활용 StringIndexOutOfBoundsException이 발생하는 부분에 대한 assertThatExceptionOfType 학습")
  void charAtTest2() {

    String value = "abc";
    int index = 10;
    assertThatExceptionOfType(IndexOutOfBoundsException.class)
        .isThrownBy(() -> value.charAt(index)).withMessageContaining("String index out of range: %d", index);
  }

}
