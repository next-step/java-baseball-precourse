package baseball;

import baseball.controller.OperatorController;

public class Application {
    private static OperatorController operatorController = OperatorController.getInstance();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        operatorController.initOperator();
    }
}
