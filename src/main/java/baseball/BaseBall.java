package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseBall {

  private final List<Character> answers;

  public BaseBall(List<Character> chars) {
    this.answers = new ArrayList<>(chars);
  }

}
