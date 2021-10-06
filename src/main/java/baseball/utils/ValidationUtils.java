package baseball.utils;

import baseball.view.GameUI;

import java.util.HashSet;
import java.util.Set;

public class ValidationUtils {

    /** 숫자만 입력 가능!
     * @param numbers
     * @return
     */
    public static boolean checkIsNumber(String numbers) {
        boolean isNumber = numbers.chars().allMatch(Character::isDigit);
        if (!isNumber) {
            GameUI.displayErrorMessage("숫자만 입력해주세요.");
        }
        return isNumber;
    }

    /** 해당 자릿수의 숫자인지 체크
     * @param numbers
     * @param length
     * @return
     */
    public static boolean checkLength(String numbers, int length) {
        if (numbers.trim().length() < length) {
            GameUI.displayErrorMessage(String.format("공백을 제외한 최소 %d자리 이상의 숫자를 입력해주세요.", length));
            return false;
        }
        return true;
    }

    public static boolean containsZero(String numbers) {
        if (numbers.contains("0")) {
            GameUI.displayErrorMessage("숫자는 1~9사이의 숫자를 입력해주세요.");
            return true;
        }
        return false;
    }

    public static boolean isDuplicate(String numbers) {
        char[] arr = numbers.toCharArray();
        Set<Character> charList = new HashSet<>();
        for(char ch : arr) {
            charList.add(ch);
        }
        return arr.length != charList.size();
    }
}
