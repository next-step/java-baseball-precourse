package baseball;

import baseball.dto.BaseballResult;

import static nextstep.utils.Console.readLine;

public class BaseballView {

    static final String inputInitMessage = "숫자를 입력해주세요 : ";
    static final String inputErrorMessage = "[ERROR] 잘못된 입력형식 입니다. 다시 입력해주세요.(입력형식 : 1~9 중 서로 다른 수로 이루어진 3자리수)";
    static final String GamEndMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";
    static final String notingMessage = "낫싱";
    static final String strikeMessage = "스트라이크 ";
    static final String ballMessage = "볼";

    BaseballController baseballController = new BaseballController();

    /*
    게임 시작
     */
    public void playBaseball(){
        String resultCode = "F";
        baseballController.initComputerNumber();

        while(!"S".equals(resultCode)){
            String inputNumber = InputNumber();
            BaseballResult baseballResult = baseballController.countStrikeBall(inputNumber);

            // 에러 발생 시
            if("E".equals(baseballResult.getResultCode())){
                System.out.println(inputErrorMessage);
                continue;
            }

            printBaseballResult(baseballResult);
            resultCode = baseballResult.getResultCode();
        }
    }

    /*
     유저 숫자 입력
     */
    private String InputNumber(){
        System.out.print(inputInitMessage);
        return readLine();
    }

    /*
     컴퓨터의 숫자와 비교한 결과를 출력
     */
    private void printBaseballResult(BaseballResult baseballResult){
        if(baseballResult.getStrike() == 0 && baseballResult.getBall() == 0){
            System.out.println(notingMessage);
            return;
        }

        if(baseballResult.getStrike() > 0){
            System.out.print(baseballResult.getStrike() + strikeMessage);
        }

        if(baseballResult.getBall() > 0){
            System.out.print(baseballResult.getBall() + ballMessage);
        }

        System.out.println();

        if("S".equals(baseballResult.getResultCode())){
            System.out.println(GamEndMessage);
        }
    }


}
