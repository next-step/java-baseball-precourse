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
    }

    /*
    스트라이크 볼 판정
     */
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

    /*
    컴퓨터 숫자 get함수
    */
    public String getComputerNumber() {
        return computerNumber;
    }

    public static int getNumberSize() {
        return numberSize;
    }

    /*
            입력된 숫자 검증
             */
    private Boolean verifyNumber(String inputNumber){
        if("".equals(inputNumber) || inputNumber.length() != numberSize){
            return false;
        }
        for (int i = 0; i < numberSize; i++) {
            if(i != inputNumber.lastIndexOf(inputNumber.charAt(i))
                || !Character.isDigit(inputNumber.charAt(i))){
                return false;
            }
        }
        return true;
    }

    /*
    스트라이크 카운트
     */
    private int countStrike(String inputNumber){
        int strike = 0;
        for(int i=0; i < numberSize; i++){
            if(computerNumber.indexOf(inputNumber.substring(i, i+1)) == i){
                strike += 1;
            }
        }
        return strike;
    }

    /*
    볼 카운트
     */
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
