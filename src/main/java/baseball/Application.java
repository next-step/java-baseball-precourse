package baseball;


import baseball.controller.BaseBallGameController;
import baseball.view.InputView;
import nextstep.utils.Console;

public class Application {

//    private static final String PLEASE_ENTER_A_NUMBER = "숫자입력";
//
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        BaseBallGameController baseBallGameController = new BaseBallGameController();
        baseBallGameController.StartingGame();
//
//        System.out.println(PLEASE_ENTER_A_NUMBER);
//        String buf = Console.readLine();
    }
}
