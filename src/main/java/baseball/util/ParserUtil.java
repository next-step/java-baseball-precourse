package baseball.util;

import java.util.ArrayList;
import java.util.List;
import org.junit.platform.commons.util.StringUtils;

public class ParserUtil {


  public static List<Integer> StringToIntegerList(String value) {
    List<Integer> returnList = new ArrayList<>();

    if (StringUtils.isBlank(value)) {
      throw new IllegalArgumentException();
    }


    if (!ValidationUtil.isLength(value)) {
      throw new IllegalArgumentException();
    }

    for(int i = 0; i < value.length(); i++) {
      Integer userBall = Character.getNumericValue(value.charAt(i));
      userBallCheckNumber(userBall);
      returnList.add(userBall);
    }

    if (!ValidationUtil.isDuplication(returnList)) {
      throw new IllegalArgumentException();
    }
    return returnList;
  }

  private static void userBallCheckNumber(Integer userBall) {
    if (!ValidationUtil.isNumber(userBall)) {
      throw new IllegalArgumentException();
    }
  }

}
