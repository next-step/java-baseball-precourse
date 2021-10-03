package baseball.utils;

public class BaseballUtils {
    /***
     * String Type Numeric 체크하는 메소드
     * @param strNum 체크가 필요한 String
     * @return
     */
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return Boolean.FALSE;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }


    /***
     * 게임에 필요한 3자리 수에 대한 정합성을 체크하는 메소드
     * Check Point
     * 1. 사용자가 입력한 3자리가 숫자 타입이 맞는가.
     * 2. 1~9까지의 숫자 타입이 맞는가.
     * 3. 랜덤으로 생성한 숫자가 서로다른 3자리 수인가.
     * @param input 검증이 필요한 String
     * @return
     */
    public static Boolean isValidInput(String input){
        if (!isNumeric(input) || input.contains("0") || input.length() != 3){
            return Boolean.FALSE;
        }
        if (input.charAt(0) != input.charAt(1)
                && input.charAt(1) != input.charAt(2)
                && input.charAt(0) != input.charAt(2)){  // 3자리의 숫자가 서로 다른가.
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
