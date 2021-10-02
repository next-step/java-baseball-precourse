package baseball;

import static enums.Errors.INPUT_ERROR_AND_REINPUT;
import static enums.Errors.getDesc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseBall {

  private final List<Character> answers;
  private boolean isAnswer = false;
  private ResultStatus status;

  public BaseBall(List<Character> chars) {
    this.answers = new ArrayList<>(chars);
  }

  public String getState(String input) {
    if(!isValidate(input)) {
      return getDesc(INPUT_ERROR_AND_REINPUT);
    }

    this.status = new ResultStatus();
    checkStatus(input);

    this.isAnswer = status.is3Strike();
    return status.getResult();
  }

  private boolean isValidate(String input) {
    if(!isNumeric(input)) {
      return false;
    }

    if(!isIndependentNum(input)){
      return false;
    }

    return input.length() == 3;
  }

  private boolean isNumeric(String num) {
    try {
      Integer.valueOf(num);
    } catch (Exception ex) {
      return false;
    }

    return true;
  }

  private boolean isIndependentNum(String num) {
    Set<Character> set = new HashSet<>();
    for(char c : num.toCharArray()) {
      set.add(c);
    }

    return set.size() == 3;
  }

  private void checkStatus(String input) {
    char[] inputChars = input.toCharArray();
    for (int i = 0; i < input.length(); i++) {
      diffChar(answers.get(i), inputChars[i]);
    }
  }

  private void diffChar(char source, char target) {
    if (source == target) {
      status.strike();
      return;
    }

    if (answers.contains(target)) {
      status.ball();
    }
  }

  public boolean isAnswer() {
    return this.isAnswer;
  }

}
