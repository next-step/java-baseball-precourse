package baseball;

public class NumberBaseBallGame {
    private Boolean gameFinish;
    private Boolean newGame;
    private String userInput;
    private Counting counting;

    private AskUser askUser;
    private BeforeCounting beforeCounting;
    private Result result;

    public void NumberBaseBallGame () {
        this.gameFinish = false;
        this.newGame = true;
        this.userInput = "";

        this.askUser = new AskUser();
        this.beforeCounting = new BeforeCounting();
        this.counting = new Counting();
        this.result = new Result();
    }

    public void gameStart() {
        do{
            clearUserInput();
            userInput = askUser.askUser();
            setAndCounting();
        } while(!gameFinish);
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
            beforeCounting.clearAnswerNumList();
            beforeCounting.makeAnswerNumList();
            beforeCounting.answerNumListToInt();
            setNewGame(false);
        }
        beforeCounting.clearInputNumList();
        beforeCounting.makeInputNumList(userInput);
    }

    public void countingStart() {
        if (counting.isCorrectAnswer(userInput, beforeCounting.answerNum)) {
            askGameFinish();
        }
        counting.clearCnt();
        counting.strikeCounting(beforeCounting.answerNumList, beforeCounting.inputNumList);
        counting.ballCounting(beforeCounting.answerNumList, beforeCounting.inputNumList);
    }

    public void setAndPrintResult() {
        if (!newGame) {
            result.makeResultMsg(counting.ballCnt, counting.strikeCnt);
            result.printResultMsg();
        }
    }

    public void askGameFinish() {
        if (gameFinish = !result.askOneMoreGame()) {
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
