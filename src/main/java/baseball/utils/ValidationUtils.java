package baseball.utils;

public class ValidationUtils {

    /** 숫자만 입력 가능!
     * @param numbers
     * @return
     */
    public static boolean checkIsNumber(String numbers) {
        boolean isNumber = numbers.chars().allMatch(Character::isDigit);
        if (!isNumber) {
            System.out.println("[ERROR] 숫자만 입력해주세요.");
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
            System.out.println(String.format("[ERROR] 공백을 제외한 최소 %d자리 이상의 숫자를 입력해주세요.", length));
            return false;
        }
        return true;
    }
}
