package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

  @Test
  @DisplayName("1,2을 ,로 split 했을 때 1과 2로 나뉘어지는지 확인하는 테스트")
  public void split1() {
    // given
    String testString = "1,2";

    // when
    String[] strings = testString.split(",");

    // then
    assertThat(strings).contains("1");
    assertThat(strings).contains("2");
    assertThat(strings).contains("1", "2");
  }

  @Test
  @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인하는 테스트")
  public void split2() {
    // given
    String testString = "1";

    // when
    String[] strings = testString.split(",");

    // then
    assertThat(strings).containsExactly("1");
  }

  @Test
  @DisplayName("(1,2)가 주어졌을 때 String의 substring() 메소드를 활용해 () 제외하고 1,2를 반환 구현 및 테스트")
  public void substring() {
    // given
    String testString = "(1,2)";
    int openBracketIndex = testString.indexOf("(");
    int closeBracketIndex = testString.indexOf(")");

    // when
    String wrongCase = testString.substring(openBracketIndex, closeBracketIndex);
    String correctCase = testString.substring(openBracketIndex + 1, closeBracketIndex);

    // then
    assertThat(wrongCase).isEqualTo("(1,2");
    assertThat(correctCase).isEqualTo("1,2");
  }

  @Test
  @DisplayName("String.charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트")
  public void charAt() {
    String testString = "abc";
    int outOfRangeIndex = 4;

    assertThatThrownBy(() -> testString.charAt(outOfRangeIndex))
      .isInstanceOf(IndexOutOfBoundsException.class)
      .hasMessageContaining("String index out of range: 4");

    assertThatExceptionOfType(IndexOutOfBoundsException.class)
      .isThrownBy(() -> testString.charAt(outOfRangeIndex)
      ).withMessageMatching("String index out of range: \\d+");
  }
}
