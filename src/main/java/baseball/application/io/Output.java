package baseball.application.io;

import baseball.domain.result.Result;

public class Output {

    public void numberInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void restartMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void resultMessage(Result result) {
        if (result.isNothing()) {
            System.out.println("낫싱");
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (result.hasBall()) {
            sb.append(String.format("%d볼 ", result.getBall()));
        }
        if (result.hasStrike()) {
            sb.append(String.format("%d스트라이크", result.getStrike()));
        }
        System.out.println(sb);
    }
}
