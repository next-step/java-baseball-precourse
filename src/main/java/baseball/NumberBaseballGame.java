package baseball;

import baseball.controller.CountingController;
import baseball.domain.Counting;
import baseball.view.UserView;

public class NumberBaseballGame {
    private Boolean gameFinish;
    private Boolean newGame;
    private String userInput;
    private Counting counting;

    private CountingController countingController;
    private UserView userView;

    public void NumberBaseBallGame() {
        this.gameFinish = false;
        this.newGame = true;
        this.userInput = "";

        this.countingController = new CountingController();
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
        if (userInput != "") {
            setCountingParams();
            countingStart();
            setAndPrintResult();
        }
    }

    public void setCountingParams() {
        if (newGame) {
            countingController.clearAnswerNumList();
            countingController.makeAnswerNumList();
            countingController.answerNumListToInt();
            setNewGame(false);
        }
        countingController.clearInputNumList();
        countingController.makeInputNumList(userInput);
    }

    public void countingStart() {
        if (counting.isCorrectAnswer(userInput, countingController.answerNum)) {
            askGameFinish();
        }
        counting.clearCnt();
        counting.strikeCounting(countingController.answerNumList, countingController.inputNumList);
        counting.ballCounting(countingController.answerNumList, countingController.inputNumList);
    }

    public void setAndPrintResult() {
        if (!newGame) {
            userView.makeResultMsg(counting.ballCnt, counting.strikeCnt);
            userView.printResultMsg();
        }
    }

    public void askGameFinish() {
        if (gameFinish = !userView.askOneMoreGame()) {
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
