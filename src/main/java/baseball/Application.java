package baseball;

import baseball.controller.NumberMaker;
import baseball.view.GameConsole;

public class Application {
    public static void main(String[] args) {
        boolean isFinish = false;
        do {
            String answer = NumberMaker.getBallNumbers();
            GameConsole gameConsole = new GameConsole(answer);
            gameConsole.playScreen();
            isFinish = gameConsole.endScreen();
        } while(isFinish);
    }
}