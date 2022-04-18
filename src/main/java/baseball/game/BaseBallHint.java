package baseball.game;

import baseball.util.BaseBallGameUtil;

public class BaseBallHint {

  int ball, strike;

  private static final String BALL_WORD = "볼";
  private static final String STRIKE_WORD = "스트라이크";
  private static final String NOT_MATCH_WORD = "낫싱";

  public String toString() {
    return "ball: " + this.ball + ", strike: " + this.strike;
  }

  private void addBallCount() {
    this.ball++;
  }

  private void addStrikeCount() {
    this.strike++;
  }

  public boolean compareAnswer(BaseBallGame answer, BaseBallGame rightAnswer) {//compare answer finish 여부 확인
    int nowNumber;
    boolean isFinish = false;
    for (int i = 0; i < BaseBallGame.NUMBER_COUNT; i++) {
      nowNumber = answer.number[i];

      if (!BaseBallGameUtil.isDuplications(rightAnswer.number, nowNumber)) {
        continue;
      }
      if (i == BaseBallGameUtil.getCompareValueAndGetIndex(rightAnswer.number, nowNumber)) {
        addStrikeCount();
        continue;
      }

      addBallCount();
    }
    hintPrint();
    if (strike == BaseBallGame.NUMBER_COUNT) isFinish = true;
    return isFinish;
  }

  private void hintPrint() {
    String result = "";
    if (this.ball != 0) {
      result += this.ball + BALL_WORD;
    }

    if (this.strike != 0) {
      if (this.ball != 0) {
        result += " ";
      }
      result += this.strike + STRIKE_WORD;
    }

    if (result.equals("")) {
      result = NOT_MATCH_WORD;
    }

    System.out.println(result);
  }
}
