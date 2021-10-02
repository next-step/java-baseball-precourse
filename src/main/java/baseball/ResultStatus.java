package baseball;

public class ResultStatus {
  private int strikeCnt;
  private int ballCnt;

  public void strike() {
    this.strikeCnt++;
  }

  public void ball() {
    this.ballCnt++;
  }

  public String now() {
    if (strikeCnt == 0 && ballCnt == 0) {
      return "낫싱";
    }

    if (strikeCnt == 0) {
      return ballCnt + "볼";
    }

    if (ballCnt == 0) {
      return strikeCnt + "스트라이크";
    }

    return strikeCnt + "스트라이크 " + ballCnt + "볼";
  }

  public boolean threeStrike() {
    return this.strikeCnt == 3;
  }
}
