package baseball;

import static baseball.BaseBallMessage.printEndOrNewMessage;

import java.util.ArrayList;

public class BaseBallPlay {

  BaseBallGenerator generator;
  BaseBallPlayer baseBallPlayer;

  private void initBaseBallPlayer() {
    baseBallPlayer = new BaseBallPlayer();
  }

  private void initBaseBallGenerator() {
    generator = new BaseBallGenerator();
  }

  public void play() {
    initBaseBallGenerator();
    initBaseBallPlayer();

    generator.generatorRandomNumbers();

    while (true) {
      BaseballUtil.printMessage("숫자를 입력해 주세요 : ");
      ArrayList<Integer> playerNumbers = baseBallPlayer.getPlayerNumbers();

      boolean isAllStrike = generator.ballStrikeNumber(playerNumbers);

      if (isAllStrike) {
        break;
      }

      printEndOrNewMessage();

      if (baseBallPlayer.confirmEndOrNew() == 1) {
        play();
      }
    }

  }
}
