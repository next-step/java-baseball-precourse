package baseball;

import nextstep.utils.Console;

public class Application {


    public static void main(String[] args) {
        String numbers = getStringNumbers();
        println("# numbers: " + numbers);
        println("# GAME END");
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
        boolean isNumber = value.matches("[0-9]+");
        return isNumber && value.length() == NUMBER_LENGTH;
    }

    private static void println(String message) {
        System.out.println(message);
    }

    private static void print(String message) {
        System.out.print(message);
    }
}