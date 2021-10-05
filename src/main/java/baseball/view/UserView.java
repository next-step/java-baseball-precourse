package baseball.view;

import baseball.service.ValidationService;
import nextstep.utils.Console;

public class UserView {
    public static final String ASK_NUMBER_INPUT_MSG = "숫자를 입력해주세요: ";
    public static final String NOTICE_FINISH_MSG = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 끝";
    public static final String ONE_MORE_GAME_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String NOTHING_MSG = "낫싱";
    private String resultMsg;

    private final ValidationService validationService;

    public UserView() {
        this.resultMsg = "";
        this.validationService = new ValidationService();
    }

    public void setAndPrintResult(Boolean newGame, Integer ballCnt, Integer strikeCnt) {
        if (!newGame) {
            makeResultMsg(ballCnt, strikeCnt);
            printResultMsg();
        }
    }

    public String askUser() {
        System.out.print(ASK_NUMBER_INPUT_MSG);
        String inputVal = Console.readLine();
        if (validationService.checkNum(inputVal) && validationService.checkCorrectLen(inputVal)
            && validationService.checkCorrectNum(inputVal)) {
            return inputVal;
        }
        return "";
    }

    public Boolean askOneMoreGame() {
        System.out.println(NOTICE_FINISH_MSG);
        System.out.println(ONE_MORE_GAME_MSG);
        String oneMoreGame = Console.readLine();
        return oneMoreGame.equals("1");
    }

    public void makeResultMsg(Integer ballCnt, Integer strikeCnt) {
        resultMsg = "";
        if (ballCnt == 0 && strikeCnt == 0) {
            resultMsg = NOTHING_MSG;
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
