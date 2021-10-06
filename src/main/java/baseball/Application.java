package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class Application {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;
    private static final int DIGIT_SIZE = 3;
    private static final String ONLY_DIGIT = "\\d+";

    public static void main(String[] args) {
        System.out.println("숫자를 입력해 주세요: ");
        String target = generateNumberString();
        String input = Console.readLine();
        if (!validateInput(input)){
            System.out.println("[ERROR] 1부터 9까지 숫자 3개만 입력해주세요. (예시) 123");
        }
    }

    private static String generateNumberString(){
        StringBuilder result = new StringBuilder();
        int counter = 0;
        while (counter < DIGIT_SIZE){
            String number = String.valueOf(Randoms.pickNumberInRange(START_RANGE, END_RANGE));
            if (result.indexOf(number) == -1){
                result.append(number);
                counter ++;
            }
        }

        return result.toString();
    }

    private static boolean validateInput(String input){
        if (input.matches(ONLY_DIGIT) && input.length() == 3){
            return true;
        }
        return false;
    }
}
