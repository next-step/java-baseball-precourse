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

  public String getResult() {
    if (strikeCnt == 0 && ballCnt == 0) {
      return "낫싱";
    }

    return getGameResult();
  }

  private String getGameResult() {
    String result = "";
    if (strikeCnt != 0) {
      result += strikeCnt + "스트라이크 ";
    }

    if (ballCnt != 0) {
      result += ballCnt + "볼";
    }

    return result.trim();
  }

  public boolean is3Strike() {
    return this.strikeCnt == 3;
  }
}
