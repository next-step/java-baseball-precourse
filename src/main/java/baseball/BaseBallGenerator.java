package baseball;

import static baseball.BaseBallMessage.print3Strike;
import static baseball.BaseBallMessage.printBallStrike;
import static baseball.BaseBallMessage.printNothing;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BaseBallGenerator {

  ArrayList<Integer> randomNumbers = new ArrayList<>();
  Set<Integer> resultNumbers = new HashSet<>();

  public void generatorRandomNumbers() {
    while (randomNumbers.size() < 3) {
      int num = Randoms.pickNumberInRange(1, 9);

      if (randomNumbers.contains(num)) {
        return;
      }

      randomNumbers.add(num);
      resultNumbers.add(num);
    }
  }

  public boolean ballStrikeNumber(ArrayList<Integer> userNumber) {
    int ballNumber = 0;
    int strikeNumber = 0;

    for (int i = 0; i < 3; i++) {
      if (userNumber.get(i)
          .equals(randomNumbers.get(i))) {
        strikeNumber++;
        continue;
      }
      if (resultNumbers.contains(userNumber.get(i))) {
        ballNumber++;
      }
    }
    return isBallStrike(ballNumber, strikeNumber);
  }

  public boolean isBallStrike(int ballNumber, int strikeNumber) {
    if (strikeNumber == 3) {
      print3Strike();

      return true;
    }

    if (strikeNumber == 0 && ballNumber == 0) {
      printNothing();
    }

    printBallStrike(ballNumber, strikeNumber);

    return false;
  }

}
