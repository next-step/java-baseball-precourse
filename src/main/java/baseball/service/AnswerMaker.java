package baseball.service;

import static nextstep.utils.Randoms.pickNumberInRange;

public class AnswerMaker {

    public static String make() {
        return make("");
    }

    private static String make(String answer) {
        if (answer.length() == 3){
            return answer;
        }

        String newNumber = Integer.toString(pickNumberInRange(1, 9));
        while (answer.contains(newNumber)) {
            newNumber = Integer.toString(pickNumberInRange(1, 9));;
        }
        answer += newNumber;
        return make(answer);
    }

    public static boolean isValid(String answer) {
        return answer.matches("^(?!.*(.).*\\1)[1-9]{3}$");
    }

//    public static boolean isValid(String answer) {
//        return !isContainsZero(answer)
//          && isLengthThree(answer)
//          && isOnlyDigits(answer)
//          && isNoRepeat(answer);
//    }
//
//    private static boolean isContainsZero(String answer) {
//        return answer.contains("0");
//    }
//
//    private static boolean isLengthThree(String answer) {
//        return answer.length() == 3;
//    }
//
//    private static boolean isOnlyDigits(String answer) {
//        boolean result = true;
//        for (char c: answer.toCharArray()) {
//            result = result && Character.isDigit(c);
//        }
//        return result;
//    }
//
//    private static boolean isNoRepeat(final String answer) {
//
//
//    }
}
