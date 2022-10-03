package baseball.utils;

public abstract class UserInputValidator {


    protected String userInputString;

    UserInputValidator(String userInputString){
        this.userInputString = userInputString;
    }

    public abstract void isValidValue();


}
