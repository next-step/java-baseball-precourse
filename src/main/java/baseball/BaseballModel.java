package baseball;

import baseball.dto.BaseballResult;
import nextstep.utils.Randoms;

public class BaseballModel {
    static final private int numberSize = 3;
    private String computerNumber = "";

    /*
   게임을 위한 컴퓨터 숫자 생성
    */
    public void initComputerNumber(){
        computerNumber = "";
        String number = "";
        while(computerNumber.length() < numberSize){
            number = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if(computerNumber.indexOf(number) == -1){
                computerNumber = computerNumber + number;
            }
        }

        System.out.println(computerNumber);
    }

    public BaseballResult countStrikeBall(String iuputNumber){
        int strike = 0;
        int ball = 0;
        String resultCode = "F";

        // 입력값이 잘못된경우
        if(!verifyNumber(iuputNumber)){
            return new BaseballResult(strike, ball, "E");
        }

        strike = countStrike(iuputNumber);
        ball = countBall(iuputNumber);

        // 모든 숫자가 스트라이크면 결과코드 S
        if(strike == numberSize){
            resultCode = "S";
        }

        return new BaseballResult(strike, ball, resultCode);
    }

    private Boolean verifyNumber(String inputNumber){

        return true;
    }

    private int countStrike(String inputNumber){
        int strike = 0;
        for(int i=0; i < numberSize; i++){
            if(computerNumber.indexOf(inputNumber.substring(i, i+1)) == i){
                strike += 1;
            }
        }
        return strike;
    }

    private int countBall(String inputNumber){
        int ball = 0;
        for(int i=0; i < numberSize; i++){
            if(computerNumber.indexOf(inputNumber.substring(i, i+1)) != i
                && computerNumber.indexOf(inputNumber.substring(i, i+1)) != -1){
                ball += 1;
            }
        }
        return ball;
    }
}
