package baseball.game.ui;

import baseball.game.Baseball;

import java.util.Map;

public class Screen {

    public void printInputNumberMessage() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public void printGameOverMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printGameResultMessage(Map<String, Integer> result) {
        System.out.println(makeResultMessage(result.get(Baseball.BALLS), result.get(Baseball.STRIKES)));
    }

    public String makeResultMessage(int balls, int strikes) {
        if (isNothing(balls, strikes)) {
            return "낫싱";
        }
        return makeMessage(balls, strikes);
    }

    private boolean isNothing(int balls, int strikes) {
        return balls == 0 && strikes == 0;
    }

    private String makeMessage(int balls, int strikes) {
        String msg = "";
        if (balls > 0) {
            msg = balls + "볼";
        }
        if (strikes > 0) {
        	return concatenateMessages(msg, strikes + "스트라이크");
        }
        return msg;
    }

    private String concatenateMessages(String msg, String newMsg) {
        if (msg != null && msg.length() == 0) {
            return msg += newMsg;
        }
        return msg + " " + newMsg;
    }

}
