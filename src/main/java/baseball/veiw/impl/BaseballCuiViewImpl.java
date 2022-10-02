package baseball.veiw.impl;

import baseball.model.InningResultData;
import baseball.veiw.BaseballCuiView;

public class BaseballCuiViewImpl implements BaseballCuiView {
    @Override
    public void printInputNumber() {
        String INPUT_NUMBER = "숫자를 입력해주세요 : ";
        System.out.print(INPUT_NUMBER);
    }

    @Override
    public void printInningResult(InningResultData inningResult) {
        String result = "";

        if (inningResult.getBall() != 0) {
            String INNING_RESULT_BALL_FORMAT = "%d볼";
            result += String.format(INNING_RESULT_BALL_FORMAT, inningResult.getBall());
        }

        if (inningResult.getStrike() != 0) {
            String INNING_RESULT_STRIKE_FORMAT = " %d스트라이크";
            result += String.format(INNING_RESULT_STRIKE_FORMAT, inningResult.getStrike());
        }

        if (inningResult.isNothing()) {
            String INNING_RESULT_NOTHING = "낫싱";
            result += INNING_RESULT_NOTHING;
        }

        result = result.trim();
        System.out.println(result);
    }

    @Override
    public void printRestartQuestion() {
        String RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
        System.out.print(RESTART);
    }

    @Override
    public void printEnding(int strike) {
        String ENDING_RESULT_FORMAT = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료";
        System.out.println(String.format(ENDING_RESULT_FORMAT, strike));
    }
}
