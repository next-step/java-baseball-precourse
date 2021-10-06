package baseball;

import baseball.dto.BaseballResult;

public class BaseballController {

    BaseballModel baseballModel = new BaseballModel();

    /*
    게임을 위한 컴퓨터 숫자 생성
    */
    public void initComputerNumber(){
        baseballModel.initComputerNumber();
    }

    /*
    스트라이크 볼 판정
     */
    public BaseballResult countStrikeBall(String iuputNumber){
        return baseballModel.countStrikeBall(iuputNumber);
    }
}
