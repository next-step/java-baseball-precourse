package baseball.model;

public class NumberCheckUtil {
    // 게임 플레이어가 입력한 숫자 유효성 체크 기능
    public static boolean isValid(String num) throws IllegalArgumentException {
        // 입력한 문자가 초기화 값인지 체크
        if (isReset(num))
            return false;

        // 문자열 길이 체크
        if (num.length() != 3 && !num.equals("1") && !num.equals("2"))
            throw new IllegalArgumentException();

        // scope 내 문자인지 체크
        for (String str : num.split(""))
            isInScope(str);

        // 입력된 문자열에서 중복된 문자 체크
        isDuplicate(num.toCharArray());

        return true;
    }

    // 입력값이 1일 경우 초기화
    private static boolean isReset(String num) {
        if (num.equals("1")) {
            Computer.getInstance().reset();
            return true;
        }
        return false;
    }

    // 입력한 문자가 유효한 범위 내에 있는지 체크
    private static void isInScope(String str) throws IllegalArgumentException {
        String scope = "123456789";

        if (!scope.contains(str))
            throw new IllegalArgumentException();
    }

    // 입력된 문자열에서 중복된 문자 체크
    private static void isDuplicate(char[] chars) throws IllegalArgumentException {
        if (chars[0] == chars[1] || chars[0] == chars[2])
            throw new IllegalArgumentException();

        if (chars[1] == chars[2])
            throw new IllegalArgumentException();
    }
}
