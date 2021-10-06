package baseball.ui;

import baseball.domain.CheckResult;
import nextstep.utils.Console;

public class UI {

    public static final String GAME_START = "숫자를 입력해주세요 :";
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String NOTHING = "낫싱";
    public static final String ERROR = "[ERROR] 다시 입력해주세요. ";
    public static final String GAME_CLEAR = "3개의 숫자를 모두 맞히셨습니다! 게임 끝\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String startAndInputNumber(){
        printLine(GAME_START);
        String input = readLine();
//        printEnter();
        return input;
    }

    public void printError(){
        printLine(ERROR);
        printEnter();
    }

    private void printLine(String value){
        System.out.print(value);
    }

    private void printEnter(){
        System.out.println();
    }

    private String readLine(){
        return Console.readLine();
    }

    public void printResult(CheckResult checkResult) {
        printLine(checkResult.checkResultString());
        printEnter();
    }

    public boolean getSelection() {
        return selectToBoolean(selectRestartGame());
    }

    private boolean selectToBoolean(String input){
        boolean result = false;

        if(input.equals("1")){
            result = true;
        }
        return result;
    }

    private String selectRestartGame(){
        String select = null;
        printLine(GAME_CLEAR);
        printEnter();

        do{
            select = readLine();
        }
        while (!validSelection(select));

        return select.trim();
    }

    private boolean validSelection(String select) {
        boolean check = false;
        if(select.equals("1") || select.equals("2")){
            check = true;
        }
        return check;
    }

}
