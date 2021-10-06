package baseball;

import baseball.controller.PlayGroundManager;

import nextstep.utils.Console;

public class Application {
    private static final String REQUEST_INPUT_MSG = "숫자를 입력해주세요: ";

    private static PlayGroundManager playGroundManager;

    public static void main(String[] args) {
        playGroundManager = new PlayGroundManager();

        launch();
    }

    private static void launch() {
        playGroundManager.standByGame();

        boolean isContinuePlaying = true;

        while (isContinuePlaying) {
            isContinuePlaying = playGroundManager.proceedGame(readInput());
        }
    }

    private static String readInput() {
        System.out.println(REQUEST_INPUT_MSG);

        return Console.readLine();
    }
}
