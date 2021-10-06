package baseball.model;
import nextstep.utils.Validation;

public class BaseballPlayer {
    private static int number;

    public BaseballPlayer(String inputNumber){
        this.number = Integer.parseInt(inputNumber);
    }
    public int getNumber(){
        return this.number;
    }

    public boolean verifyNumber(int inputNumber){
        return Validation.checkNumberValidation(inputNumber);
    }
}
