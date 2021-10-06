package baseball;

import baseball.dto.BaseballResult;
import nextstep.utils.Randoms;

public class BaseballModel {

    private String computerNumber = "";

    public BaseballResult countStrikeBall(String iuputNumber){

        return new BaseballResult();
    }

    public void initComputerNumber(){
        computerNumber = "";
        String number = "";
        while(computerNumber.length() < 3){
            number = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if(computerNumber.indexOf(number) == -1){
                computerNumber = computerNumber + number;
            }
        }
        System.out.println(computerNumber);
    }
}
