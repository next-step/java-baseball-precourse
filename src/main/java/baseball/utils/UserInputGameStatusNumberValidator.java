package baseball.utils;

import baseball.Constants.UserInputRange;

import static baseball.Constants.ErrorMessage.*;
import static baseball.Constants.UserInputRange.*;


public class UserInputGameStatusNumberValidator extends UserInputValidator {

    public UserInputGameStatusNumberValidator(String userInputString) {
        super(userInputString);
    }

    @Override
    public void isValidValue() {
        isValidLength();
        isValidRange();
    }

    private void isValidLength(){
        if(userInputString.length() != INPUT_GAME_STATUS_MAX_DIGIT){
            throw new IllegalArgumentException(WRONG_LENGTH_MESSAGE);
        }
    }

    private void isValidRange(){
        if(Character.getNumericValue(userInputString.charAt(0)) != INPUT_GAME_STATUS_MIN_NUM
                && Character.getNumericValue(userInputString.charAt(0)) != INPUT_GAME_STATUS_MAX_NUM){
            throw new IllegalArgumentException(WRONG_NUMBER_MESSAGE);
        }
    }
}
