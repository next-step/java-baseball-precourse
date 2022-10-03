package baseball;

import baseball.controller.BaseBallController;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseBallGame {
    private BaseBallController baseBallController;
    public BaseBallGame(BaseBallController baseBallController) {
        this.baseBallController = baseBallController;
    }

    public void run() {
        String result = "";
        boolean isContinue = true;
        boolean isRetry = false;

        do {
            String data = getUserData(isRetry);

            if (isRetry && checkRetryData(data)) {
                isRetry = false;
                baseBallController.initData();
                continue;
            }

            if (isRetry && !checkRetryData(data)) {
                System.out.println("게임 종료");
                break;
            }

            result = baseBallController.checkValidData(data);

            System.out.println(result);

            if (baseBallController.isStop()) {
                isRetry = true;
            }

        } while (isContinue);

    }

    private boolean checkRetryData(String data) {
        if ("1".equals(data)) return true;
        if ("2".equals(data)) {
            return false;
        }
        throw new IllegalArgumentException("1 또는 2를 입력해 주세요.");
     }


    public String getUserData(boolean isRetry) {
        String message =  "숫자를 입력해주세요 : ";
        if(isRetry) message = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
        System.out.print(message);
        return readLine();
    }
}
