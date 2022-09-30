package baseball.common;

import java.util.HashSet;
import java.util.Set;

/**
 * author : hyeongju
 * date : 2022.09.28
 * description : 입력받은 문자열이 유효한 값인지 검증한다.
 */
public class Validator {

    public static boolean isBaseBallValid(String input){

        if(!is3NumberValid(input)){
            throw new IllegalArgumentException(Message.MSG_INPUT_ERROR.getMessage());
        }

        if(!isDuplicateNumberValid(input)){
            throw new IllegalArgumentException(Message.MSG_INPUT_ERROR.getMessage());
        }

        return true;

    }

    private static boolean is3NumberValid(String input){
        return input.matches("^[1-9]{3}$");
    }

    private static boolean isDuplicateNumberValid(String input){
        Set<Integer> numbers = new HashSet<>();
        String[] split = input.split("");

        for (String s: split){
            numbers.add(Integer.parseInt(s));
        }

        return numbers.size() == 3;
    }

    public static boolean isCommandValid(String command){
        return command.matches("^[1-2]{1}$");
    }

}
