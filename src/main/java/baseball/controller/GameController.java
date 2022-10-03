package baseball.controller;

import baseball.constant.CommonConstant;
import baseball.model.Baseball;
import baseball.model.Config;
import baseball.model.Message;
import baseball.model.Number;
import baseball.service.ManageService;
import baseball.service.SystemService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private Baseball baseball;
    private Number number;
    private SystemService systemService;
    private ManageService manageService;


    public void beforeStart() {
        initConfig();
        initGame();

        while(baseball.isAvailableStart()) {
            gameStart();
            askRestart();
        }
    }

    public void gameStart() {
      while(!baseball.isEnd()) {
          InputView.inputNumber();
          number.setPlayerNum(systemService.getReadLine());
          manageService.checkPlayerNum(number.getPlayerNum());

          baseball = manageService.getAnswer(number.getPlayerNum(), number.getRandomNum());

          Message message = new Message(baseball);
          OutputView.printResult(message.getResultMeesage());

          if(baseball.isEnd()) {
              OutputView.printEnd();
          }

      }
    }

    private void askRestart() {
        InputView.askRestart();
        String inputStr = systemService.getReadLine();
        manageService.checkRestartGameNumber(inputStr);

        boolean isRestart = inputStr.equals(CommonConstant.AGREE_RESTART);
        if (isRestart) {
            initGame();
        }
    }

    private void initConfig() {
        Config appConfig = new Config();
        manageService = appConfig.manageService();
        systemService = appConfig.systemService();
    }


    private void initGame() {
        baseball = Baseball.initBaseBall();
        number = Number.initNumber(systemService.setRandomNumber(CommonConstant.NUMBER_LENGTH));
    }

}

