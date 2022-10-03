package baseball.view;

import baseball.constant.CommonConstant;

public class OutputView {
    public static void printResult(String resultMessage) {
        System.out.print(resultMessage);
    }

    public static void printEnd() {
        System.out.print(CommonConstant.SUCCESS_END_GAME);
    }
}
