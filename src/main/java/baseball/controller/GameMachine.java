package baseball.controller;

import baseball.service.BaseballGameService;
import baseball.view.ConsolePrinter;
import baseball.view.Messages;
import baseball.view.ConsoleScanner;

public class GameMachine {
    private BaseballGameService baseBallGameService;
    private static final String gameButtonPattern = "^[1-2]*$";
    private static final String REPLAY_NUM = "1";

    public void playBaseballGame() {

        String gameReplayButton = new String();
        do {
            baseBallGameService = new BaseballGameService();
            baseBallGameService.playGame();
            ConsolePrinter.printConsoleMsg(Messages.ASK_REPLAY.getMsg());
            gameReplayButton = ConsoleScanner.getUserInput();
            validateUserInput(gameReplayButton);
        } while (REPLAY_NUM.equals(gameReplayButton));
    }

    public void validateUserInput(String gameReplayButton) {
        if (gameReplayButton.length() != 1) {
            System.out.println("게임 버튼 길이 오류");
            throw new IllegalArgumentException();
        }

        if (!gameReplayButton.matches(gameButtonPattern)) {
            System.out.println("게임 버튼 값 오류");
            throw new IllegalArgumentException();
        }
    }
}
