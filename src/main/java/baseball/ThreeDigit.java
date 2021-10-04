package baseball;

import nextstep.utils.Randoms;

public class ThreeDigit {

    public static String get() {
        StringBuilder sb = new StringBuilder();
        while(sb.length() < 3) {
            String num =Randoms.pickNumberInRange(1,9) + "";
            sb = addNumber(sb, num);
        }
        return sb.toString();
    }

    private static StringBuilder addNumber(StringBuilder sb, String number) {
        if (sb.indexOf(number) == -1) {
            sb.append(number);
        }
        return sb;
    }
}
