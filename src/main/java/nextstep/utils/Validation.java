package nextstep.utils;

import java.util.HashSet;

public class Validation {

    /**
     * 숫자가 규칙에 일치하는지 검증하는 java api
     */

    private Validation() {
    }

    /**
     * 입력한 숫자가 규칙에 일치하는지 반환하는 기능을 수행한다. 규칙에 일치하면 True 를, 일치하지 않으면 False 를 반환한다.
     * <p>
     * 입력한 값을 각 자릿수의 3가지로 나누어 비교해 반환한다. 0이 포함되어 규칙을 벗어났는지 여부를 반환한다. 예를 들어 012 일 경우 false 반환.
     * </p>
     * 0이 포함되어 있지 않다면, 중복값 여부를 반환한다. 예를 들어 129일 경우,  메소드를 호출할 경우, 1과2, 1과9, 2와9를 비교하여 중복 값 여부를 반환한다.
     * </p>

     *
     * @param number 범위의 시작값, 리턴 범위내에 포함된다.
     * @return 규칙에 일치하면 True, 일치하지않는다면 False
     * @throws IllegalArgumentException 스택오버플로우가 터질 수 있는 경우, 발생한다. 잘못된 범위가 입력되는 경우, 발생한다.
     */

    public static boolean checkNumberValidation(final int number) {
        boolean isValidated = checkSizeIsThree(number);
        if (checkNumberContainsZero(number)) isValidated = false;
        if (checkOverlap((number))) isValidated = false;
        return isValidated;
    }

    private static boolean checkSizeIsThree(final int number){
        String numberString = String.valueOf(number);
        return numberString.length()==3;
    }

    private static boolean checkNumberContainsZero(final int number) {
        String numberString = String.valueOf(number);
        return numberString.contains("0");
    }

    private static boolean checkOverlap(final int number){
        String numberString = String.valueOf(number);
        HashSet<Integer> numberList = new HashSet<>();
        for (int numberIdx = 0; numberIdx < numberString.length(); numberIdx++){
            if (numberList.contains(numberString.indexOf(numberIdx))) return true;
            numberList.add(numberString.indexOf(numberIdx));
        }
        return false;
    }

}
