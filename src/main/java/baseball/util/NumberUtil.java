package baseball.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class NumberUtil {
    private static final Pattern NUMBERS_PATTERN = Pattern.compile("\\d+?");

    /**
     * 텍스트가 숫자인지 체크
     * @param text
     * @return
     */
    public static boolean isNumber(String text){
        if(text == null)
            return false;
        return NUMBERS_PATTERN.matcher(text).matches();
    }

    /**
     * 텍스트를 숫자 리스트로 변환
     * @param text
     * @return
     */
    public static List<Integer> splitNumberByString(String text){
        NumberUtil.validateNumber(text);
        List<Integer> numbers = new ArrayList<>();
        for(int i=0, length=text.length() ; i < length; i++) {
            numbers.add(Character.digit(text.charAt(i), 10));
        }
        return numbers;
    }

    /**
     * 숫자 검증
     * @param text
     */
    public static void validateNumber(String text) {
        if(!isNumber(text)){
            throw new IllegalArgumentException("is not number");
        }
    }
}
