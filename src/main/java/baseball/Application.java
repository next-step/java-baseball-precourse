package baseball;

import baseball.controller.baseballGameController;
import baseball.view.UserInputView;

public class Application {
        public static void main(String[] args) {
                // TODO: 프로그램 구현

                baseballGameController.run();

                UserInputView userinput = new UserInputView();

                String a = userinput.requireBaseBallNumber();

                System.out.println(a);

        }
}
