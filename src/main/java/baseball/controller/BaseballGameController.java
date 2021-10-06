package baseball.controller;

import baseball.service.CountingService;
import baseball.view.UserView;
import baseball.vo.GameResultVO;

public class BaseballGameController {
    private Boolean gameFinish;
    private Boolean newGame;
    private String userInput;

    private CountingService countingService;
    private UserView userView;
    private GameResultVO gameResultVO;

    public BaseballGameController() {
        this.gameFinish = false;
        this.newGame = true;
        this.userInput = "";

        this.countingService = new CountingService();
        this.userView = new UserView();
    }

    public void gameStart() {
        do {
            clearUserInput();
            userInput = userView.askUser();
            setAndCounting();
        } while (!gameFinish);
    }

    public void clearUserInput() {
        this.userInput = "";
    }

    public void setAndCounting() {
         if (!userInput.equals("")) {
             boolean newGameResult = countingService.setCountingParams(newGame, userInput);
             setNewGame(newGameResult);
             countingStart();
             userView.setAndPrintResult(newGame, gameResultVO.getBallCnt(), gameResultVO.getStrikeCnt());
        }
    }

    public void countingStart() {
        boolean isAnswer = countingService.isCorrectAnswer(userInput);
        if (isAnswer) {
            askGameFinish();
        }
        gameResultVO = countingService.countingStart();
    }

    public void askGameFinish() {
        gameFinish = !userView.askOneMoreGame();
        if (gameFinish) {
            setNewGame(true);
            setGameFinish(true);
            return;
        }
        setNewGame(true);
        setGameFinish(false);
    }

    public void setGameFinish(Boolean input) {
        this.gameFinish = input;
    }

    public void setNewGame(Boolean input) {
        this.newGame = input;
    }

}
