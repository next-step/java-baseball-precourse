package baseball.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidateUtils {

    public static Integer StringToNumber(String input, int minNumber, int maxNumber) {
        if(!Character.isDigit(input.charAt(0))){
            throw new NumberFormatException("[ERROR] 숫자만 입력가능합니다");
        }
        rangeCheck(Integer.parseInt(input), minNumber, maxNumber);
        return Integer.parseInt(input);
    }

    public static void lengthCheck(List<Integer> inputList, int gameNumberDigits) {
        if(inputList.size() < gameNumberDigits || inputList.size() > gameNumberDigits){
            throw new IllegalArgumentException(String.format("[ERROR] %s개의 숫자를 입력해주세요",gameNumberDigits));
        }
    }

    public static void duplicateNumberCheck(List<Integer> inputList){
        Set<Integer> set = new HashSet<>(inputList);
        if(set.size() < inputList.size()){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다");
        }
    }

    private static void rangeCheck(int number, int minNumber, int maxNumber) {
        if (number > maxNumber ||  number < minNumber) {
            throw new IllegalArgumentException(String.format("[ERROR] [%s-%s] 범위의 숫자를 입력해주세요",minNumber, maxNumber));
        }
    }
}
