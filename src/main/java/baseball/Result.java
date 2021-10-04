package baseball;

import nextstep.utils.Console;

public class Result {
    public static String noticeFinishMsg = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 끝";
    public static String oneMoreGameMsg = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static String nothingMsg = "낫싱";
    public static String gameFinishMsg = "게임이 종료되었습니다.";
    public String resultMsg = "";

    public Result() {
        this.resultMsg = "";
    }

    public Boolean askOneMoreGame() {
        System.out.println(noticeFinishMsg);
        System.out.println(oneMoreGameMsg);
        String oneMoreGame = Console.readLine();
        if (oneMoreGame.equals("1")) {
            return true;
        }
        return false;
    }

    public void makeResultMsg(Integer ballCnt, Integer strikeCnt) {
        resultMsg = "";
        if (ballCnt == 0 && strikeCnt == 0) {
            resultMsg = nothingMsg;
        }
        if (strikeCnt > 0) {
            resultMsg += strikeCnt + "스트라이크 ";
        }
        if (ballCnt > 0) {
            resultMsg += ballCnt + "볼";
        }
    }

    public void printResultMsg() {
        System.out.println(resultMsg);
    }

}
