package baseball;

import baseball.dto.BaseballResult;

public class BaseballController {

    BaseballModel baseballModel = new BaseballModel();
    /*

     */
    public BaseballResult countStrikeBall(String iuputNumber){
        return baseballModel.countStrikeBall(iuputNumber);
    }

    public void initComputerNumber(){
        baseballModel.initComputerNumber();
    }
}
