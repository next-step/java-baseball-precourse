package baseball.controller;

import baseball.domain.Counting;
import baseball.service.CountingService;
import baseball.view.UserView;

/*
    숫자야구 게임 Controller
 */
public class BaseballGameController {
    private Boolean gameFinish;
    private Boolean newGame;
    private String userInput;
    private Counting counting;

    private CountingService countingService;
    private UserView userView;

    public BaseballGameController() {
        this.gameFinish = false;
        this.newGame = true;
        this.userInput = "";

        this.countingService = new CountingService();
        this.counting = new Counting();
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
            setCountingParams();
            countingStart();
            setAndPrintResult();
        }
    }

    public void setCountingParams() {
        if (newGame) {
            countingService.clearAnswerNumList();
            countingService.makeAnswerNumList();
            countingService.answerNumListToInt();
            setNewGame(false);
        }
        countingService.clearInputNumList();
        countingService.makeInputNumList(userInput);
    }

    public void countingStart() {
        if (counting.isCorrectAnswer(userInput, countingService.answerNum)) {
            askGameFinish();
        }
        counting.clearCnt();
        counting.strikeCounting(countingService.answerNumList, countingService.inputNumList);
        counting.ballCounting(countingService.answerNumList, countingService.inputNumList);
    }

    public void setAndPrintResult() {
        if (!newGame) {
            userView.makeResultMsg(counting.ballCnt, counting.strikeCnt);
            userView.printResultMsg();
        }
    }

    public void askGameFinish() {
        if (gameFinish = (!userView.askOneMoreGame())) {
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
