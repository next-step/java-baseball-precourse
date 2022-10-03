package baseball.service;

import baseball.domain.BallInfo;
import baseball.util.MessageUtil;
import baseball.util.ParserUtil;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseBallService {

  BallInfo ballInfo = new BallInfo();
  public BaseBallService(List<Integer> computerBalls) {
    ballInfo.setComputerBalls(computerBalls);
  }
  public void play() {
    int strike = 0;
    while (strike != 3) {
      playBaseBall();
      MessageUtil.ballCountMsg(ballInfo.getBallCnt(), ballInfo.getStrikeCnt());
      strike = ballInfo.getStrikeCnt();
    }
  }

  private void playBaseBall() {
    setBallInfo();
    score();
  }

  private void score() {
    ballInfo.score();
  }

  private void setBallInfo() {
    ballInfo.resetBallCnt();
    ballInfo.setUserBalls(getUserBalls());

  }

  private List<Integer> getUserBalls() throws IllegalArgumentException {
    MessageUtil.startMsg();
    String input = Console.readLine();
    return ParserUtil.StringToIntegerList(input);
  }

}
