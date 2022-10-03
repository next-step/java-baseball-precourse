package baseball;

import camp.nextstep.edu.missionutils.Console;
import baseball.game.controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.start();
//        while (true) {
//            String inputNumber = Console.readLine();
//            String text = Console.readLine();
//            System.out.println(text);
//        }

    }
}
