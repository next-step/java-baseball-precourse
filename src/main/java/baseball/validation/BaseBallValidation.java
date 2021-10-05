package baseball.validation;

import baseball.constant.status.GameStatus;
import baseball.model.RandomNumber;

import java.util.Set;
import java.util.regex.Pattern;

import static baseball.util.BaseBallUtil.stringToIntSet;

public class BaseBallValidation {
  private static final Pattern numberPattern = Pattern.compile("^(\\d+)$");

  public static boolean checkStringInteger(String number) {
    return numberPattern.matcher(number).matches();
  }

  public static boolean checkDuplicateNumber(Set<Integer> numbers) {
    if (numbers.size() != RandomNumber.SIZE) {
      return false;
    }

    return true;
  }

  public static boolean checkInputNumber(String input) {
    if (input.length() != RandomNumber.SIZE) {
      return false;
    }

    if (!checkStringInteger(input)) {
      return false;
    }

    return checkDuplicateNumber(stringToIntSet(input));
  }

  public static boolean checkRestartInputNumber(String input) {
    if (input.length() != 1) {
      return false;
    }

    if (!checkStringInteger(input)) {
      return false;
    }

    return GameStatus.getValueList().contains(Integer.parseInt(input));
  }
}
