package baseball.service;

import baseball.constant.Const;
import baseball.domain.Computer;
import baseball.domain.User;
import baseball.exception.InvalidUserInputException;
import baseball.view.ConsoleOutputView;
import baseball.view.UserInputView;

public class BullsAndCows {

    private final Computer computer;
    private final User user;
    private final UserInputView inputView;
    private final ConsoleOutputView outputView;
    private int strike;
    private int ball;

    public BullsAndCows() {
        this.computer = new Computer();
        this.user = new User();
        this.inputView = new UserInputView();
        this.outputView = new ConsoleOutputView();
    }

    public void start() {
        boolean gameStatus = true;
        while (gameStatus) {
            computer.initNumber();
            progressGame();
            gameStatus = isGameOver();
        }
    }

    private void progressGame() {
        boolean roundStatus = true;
        while (roundStatus) {
            initUserNumber();
            judge();
            outputView.printRoundResult(strike, ball);
            roundStatus = isRoundOver();
            resetStrikeAndBall();
        }
    }

    private boolean isGameOver() {
        String receiveUserRestart = inputView.receiveUserRestart();
        return user.isGameStop(receiveUserRestart);
    }

    private void initUserNumber() {
        try {
            String receiveInput = inputView.receiveUserInput();
            user.initNumber(receiveInput);
        } catch (InvalidUserInputException e) {
            System.out.println(e.getMessage());
            progressGame();
        }
    }

    private boolean isRoundOver() {
        if (strike == Const.ROUND_OVER_STRIKE_CONDITION) {
            outputView.printRoundOver();
            return false;
        }
        return true;
    }

    private void judge() {
        for (int i = 0; i < Const.GENERATE_NUMBER_SIZE; i++) {
            isStrike(i);
            isBall(i);
        }
        ball = ball - strike;
    }

    private void resetStrikeAndBall() {
        strike = 0;
        ball = 0;
    }

    private void isStrike(int index) {
        int userSelectNumber = user.getNumbers().get(index);
        int computerSelectNumber = computer.getNumbers().get(index);
        if (userSelectNumber == computerSelectNumber) {
            strike++;
        }
    }

    private void isBall(int index) {
        if (computer.getNumbers().contains(user.getNumbers().get(index))) {
            ball++;
        }
    }


}
