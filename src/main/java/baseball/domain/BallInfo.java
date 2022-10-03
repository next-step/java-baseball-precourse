package baseball.domain;

import java.util.List;

public class BallInfo {

  final int BALL_SIZE = 3;
  private List<Integer> userBalls;
  private List<Integer> computerBalls;
  private Integer strikeCnt = 0;
  private Integer ballCnt = 0;

  public List<Integer> getUserBalls() {
    return this.userBalls;
  }

  public List<Integer> getComputerBalls() {
    return this.computerBalls;
  }

  public Integer getStrikeCnt() {
    return this.strikeCnt;
  }

  public Integer getBallCnt() {
    return this.ballCnt;
  }

  public void setUserBalls(List<Integer> userBalls) {
    this.userBalls = userBalls;
  }
  public void setComputerBalls(List<Integer> computerBalls) {
    this.computerBalls = computerBalls;
  }
  public void resetBallCnt() {
    this.ballCnt = 0;
    this.strikeCnt = 0;
  }



  public void score() {
    for (int i = 0; i < BALL_SIZE; i++) {
      compute(i);
    }
  }

  private void compute(int index) {
    int temp = -1;
    for (int i = 0; i < computerBalls.size(); i++) {
      if (computerBalls.get(i) == userBalls.get(index)) {
        temp = i;
        break;
      }
    }
    updateBallCount(index, temp);
  }

  private void updateBallCount(int index, int temp) {
    if (temp != index && temp != -1) {
      updateBall();
    }
    if (temp == index) {
      updateStrike();
    }
  }
  private void updateStrike() {
    this.strikeCnt++;
  }

  private void updateBall() {
    this.ballCnt++;
  }

}
