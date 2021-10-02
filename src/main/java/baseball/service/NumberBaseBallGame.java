package baseball.service;

import baseball.domain.InputBall;
import baseball.domain.RandomBall;
import baseball.view.InputView;
import baseball.view.OutputView;

public class NumberBaseBallGame {

    final private InputView inputView;
    final private OutputView outputView;
    final private RandomBall randomBall;
    final private InputBall inputBall;

    public NumberBaseBallGame() {
        this.randomBall = new RandomBall();
        this.inputView = new InputView();
        this.inputBall = new InputBall();
        this.outputView = new OutputView();
    }

    private void initializeGame() {
        randomBall.initializeRandomNumbers();
    }

    public void start() {
        initializeGame();
        do {
            play();
            outputView.printResult(randomBall.getMatchMessage());
        } while (!isSuccess());
    }

    public Boolean end() {
        Boolean reStart = inputView.isReStart();
        return reStart ? true : false;
    }

    private void play() {
        String inputNumber = inputView.getUserInputNumber();
        baseBallOf(inputNumber);
        randomBall.matchBalls(inputBall.getBalls());
    }

    public Boolean isSuccess() {
        if (randomBall.isSuccess()) {
            outputView.printEndMessage();
            return true;
        }
        return false;
    }

    private void baseBallOf(String inputNumber) {
        try {
            inputBall.of(inputNumber);
        } catch (NullPointerException npe) {
            outputView.printErrorMessage(npe.getMessage());
            play();
        } catch (IllegalArgumentException iae) {
            outputView.printErrorMessage(iae.getMessage());
            play();
        }
    }


}
