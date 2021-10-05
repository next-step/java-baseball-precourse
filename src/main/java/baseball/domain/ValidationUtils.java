package baseball.domain;

public class ValidationUtils {
    // 숫자인지 아닌지
    public static boolean checkIsNumber(String numbers) {
        boolean isNumber = numbers.chars().allMatch(Character::isDigit);
        return isNumber;
    }
}
