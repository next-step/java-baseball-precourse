package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.util.ParserUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParserUtilTest {


  //입력값 파싱
  @DisplayName("입력값 string -> List<Integer>  변경  ")
  @Test
  void getParseIntList() {
    String input = "123";
    List<Integer> parseList = ParserUtil.StringToIntegerList(input);
    assertThat(Arrays.asList(1, 2, 3)).isEqualTo(parseList);
  }

}
