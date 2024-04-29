package util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    private InputValidator() {
    }

    static public ArrayList<Integer> validateThreeUniqueNumbers(String input) {
        //3개
        if (!isThreeLength(input)) {
            throw new IllegalArgumentException();
        }
        //숫자인가
        if (!isNumber(input)) {
            throw new IllegalArgumentException();
        }
        //유니크?
        if (!isAllUniqueNumber(input)) {
            throw new IllegalArgumentException();
        }
        ArrayList<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            userNumbers.add(Character.getNumericValue(input.charAt(i)));
        }
        return userNumbers;
    }

    static public int validateOneOrTwo(String input) {
        if (!isOneLength(input)) {
            throw new IllegalArgumentException();
        }
        if (!isOneOrTwo(input)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }

    private static boolean isOneOrTwo(String input) {
        if ('1' <= input.charAt(0) && input.charAt(0) <= '2') {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isThreeLength(String input) {
        if (input.length() != 3) return false;
        else return true;
    }

    private static boolean isNumber(String input) {
        for (int i = 0; i < 3; i++) {
            if (!('0' <= input.charAt(i) && input.charAt(i) <= '9')) return false;
        }
        return true;
    }

    private static boolean isAllUniqueNumber(String input) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            if (set.contains(input.charAt(i))) {
                return false;
            } else {
                set.add(input.charAt(i));
            }
        }
        return true;
    }

    private static boolean isOneLength(String input) {
        if (input.length() == 1) return true;
        else return false;
    }

}
