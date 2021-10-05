package baseball.view;

import baseball.model.CheckResult;
import nextstep.utils.Console;

public class OutputView {

    public static void printResult(CheckResult checkResult){
        StringBuilder builder = new StringBuilder();

        builder.append(getStrikeText(checkResult.getStrike()));
        builder.append(getBallText(checkResult.getBall()));

        if(builder.length()==0){
            builder.append("낫싱");
        }
        System.out.println(builder.toString());
    }

    public static void printEndingMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    private static String getStrikeText(int strike){
        if(strike == 0){
            return "";
        }
        return strike + "스트라이크 ";
    }

    private static String getBallText(int ball){
        if(ball == 0){
            return "";
        }
        return ball + "볼";
    }
}
