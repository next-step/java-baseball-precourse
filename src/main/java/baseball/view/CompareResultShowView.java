package baseball.view;

import baseball.domain.CompareResult;

public class CompareResultShowView {
    public void show(CompareResult compareResult) {
        System.out.println(getMessage(compareResult));
    }

    private String getMessage(CompareResult compareResult) {
        if (compareResult.isNothing()) {
            return "낫싱";
        }
        if (compareResult.isSuccess()) {
            return String.format("%1$s스트라이크\n%1$s개의 숫자를 모두 맞히셨습니다! 게임 끝", compareResult.getStrike());
        }
        return createMessageByStrikeAndBall(compareResult.getStrike(), compareResult.getBall());
    }

    private String createMessageByStrikeAndBall(int strike, int ball) {
        StringBuffer sb = new StringBuffer();
        if (strike != 0) {
            sb.append(String.format("%d스트라이크 ", strike));
        }
        if (ball != 0) {
            sb.append(String.format("%d볼 ", ball));
        }
        return sb.toString();
    };
}
