package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Application {


    public static void main(String[] args) {
        Set<Integer> systemNumberSet = generateThreeNumberSet();
        String inputNumbers = getStringNumbers();
    }

    public static String getStringNumbers() {
        while (true) {
            printStartMessage();
            String inputValue = Console.readLine();
            if(isValidate(inputValue)) {
                return inputValue;
            }
            printErrorMessage();
        }
    }

    public static Set<Integer> generateThreeNumberSet() {
        final int START_INCLUSIVE = 0;
        final int END_INCLUSIVE = 9;
        final int PICK_NUMBER_COUNT = 3;

        Set<Integer> numberSet = new HashSet<>();
        while (numberSet.size() < PICK_NUMBER_COUNT) {
            numberSet.add(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
        }
        return numberSet;
    }

    private static void printStartMessage() {
        final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
        print(INPUT_MESSAGE);
    }

    private static void printErrorMessage() {
        final String ERROR_MESSAGE = "[ERROR] 3자리 숫자만 입력가능합니다.";
        println(ERROR_MESSAGE);
    }

    private static boolean isValidate(String value) {
        final int NUMBER_LENGTH = 3;
        return isNumber(value) && value.length() == NUMBER_LENGTH;
    }

    private static boolean isNumber(String value) {
        if(isBlank(value)) {
            return false;
        }
        return value.matches("[0-9]+");
    }

    private static boolean isBlank(String value) {
        return value == null || "".equals(value.trim());
    }

    private static void println(String message) {
        System.out.println(message);
    }

    private static void print(String message) {
        System.out.print(message);
    }
}