package baseball.utils;

import baseball.Constants.UserInputRange;

import java.util.HashSet;
import java.util.Set;

import static baseball.Constants.ErrorMessage.*;
import static baseball.Constants.UserInputRange.*;

public class UserInputBaseBallNumberValidator extends UserInputValidator{


    public UserInputBaseBallNumberValidator(String userInputString){
        super(userInputString);
    }

    @Override
    public void isValidValue(){
        isValidLength();
        isValidRange();
        isUnique();
    }

    private void isValidLength(){
        if(userInputString.length() != INPUT_BASEBALL_MAX_DIGIT){
            throw new IllegalArgumentException(WRONG_LENGTH_MESSAGE);
        }
    }

    private void isValidRange(){
        for(int i=0; i<userInputString.length(); i++){
            isLessThanMax(userInputString.charAt(i));
            isGreaterThanMin(userInputString.charAt(i));
        }
    }

    private void isLessThanMax(char inputChar){
        if('0'+INPUT_BASEBALL_MAX_NUM < inputChar){
            throw new IllegalArgumentException(WRONG_NUMBER_MESSAGE);
        }
    }

    private void isGreaterThanMin(char inputChar){
        if('0'+INPUT_BASEBALL_MIN_NUM > inputChar){
            throw new IllegalArgumentException(WRONG_NUMBER_MESSAGE);
        }
    }
    private void isUnique(){
        Set<Character> setForDuplicateCheck = new HashSet<>();
        for(int i=0; i<userInputString.length(); i++){
            setForDuplicateCheck.add(userInputString.charAt(i));
        }
        if(setForDuplicateCheck.size() != userInputString.length()){
            throw new IllegalArgumentException(WRONG_UNIQUE_MESSAGE);
        }
    }
}
