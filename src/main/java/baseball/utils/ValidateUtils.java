package baseball.utils;

import baseball.exception.DuplicateNumberException;
import baseball.exception.IllegalSizeException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidateUtils {

    public static Integer StringToNumber(String input) {
        if(!Character.isDigit(input.charAt(0))){
            throw new NumberFormatException("[ERROR] 숫자만 입력가능합니다");
        }
        return Integer.parseInt(input);
    }

    public static void lengthCheck(List<Integer> inputList, int gameNumberDigits) {
        if(inputList.size() < gameNumberDigits || inputList.size() > gameNumberDigits){
            throw new IllegalSizeException(gameNumberDigits);
        }
    }

    public static void duplicateNumberCheck(List<Integer> inputList){
        Set<Integer> set = new HashSet<>(inputList);
        if(set.size() < inputList.size()){
            throw new DuplicateNumberException();
        }
    }
}
