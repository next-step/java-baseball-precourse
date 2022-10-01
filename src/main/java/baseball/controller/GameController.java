package baseball.controller;

import static baseball.view.GameInputView.readWantGameOver;
import static baseball.view.GameOutputView.printCompleteGame;
import static baseball.view.GameOutputView.printMission;
import static baseball.view.GameInputView.readNumber;
import static baseball.view.GameOutputView.printMissionResult;
import static baseball.view.GameOutputView.printWantGameOver;

import baseball.model.Computer;
import baseball.model.DifferentRandomNumberGenerator;
import baseball.model.Game;
import baseball.model.GamePlayer;
import baseball.model.GameResult;
import baseball.model.NumberControl;
import baseball.model.ReadLineNumberGenerator;

/**
 * 숫자 맞추기 게임 컨트롤러
 */
public class GameController {

    private static final int NUMBER_TOTAL_LENGTH = 3;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    private final NumberControl numberControl;

    public GameController() {
        this.numberControl = new NumberControl(NUMBER_TOTAL_LENGTH, START_INCLUSIVE, END_INCLUSIVE);
    }

    public String process() {
        Computer computer = new Computer(new DifferentRandomNumberGenerator(), numberControl);
        int strikeCount;

        do {
            printMission();
            strikeCount = doGame(computer);
        } while(strikeCount != NUMBER_TOTAL_LENGTH);

        printCompleteGame(strikeCount);
        return checkWantGameOver();
    }

    private int doGame(Computer computer) {
        GamePlayer gamePlayer = new GamePlayer(new ReadLineNumberGenerator(readNumber()), numberControl);
        GameResult gameResult = new Game(computer, gamePlayer).getGameResult();
        printMissionResult(gameResult);
        return gameResult.getStrike();
    }

    private String checkWantGameOver() {
        printWantGameOver();
        return readWantGameOver();
    }
}
