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
        int[] counted = count(target, input);
        System.out.println(generateResult(counted));
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

    private static int[] count(String target, String input){
        int[] result = new int[2];

        for (int i=0; i<input.length(); i++){
            result[0] += isStrike(target, input, i);
            result[1] += isBall(target, input, i);
        }

        return result;
    }

    private static int isBall(String target, String input, int index){
        char icur = input.charAt(index);
        char tcur = target.charAt(index);

        if (tcur == icur){
            return 0;
        }
        if (target.indexOf(icur) == -1){
            return 0;
        }

        return 1;
    }

    private static int isStrike(String target, String input, int index){
        char icur = input.charAt(index);
        char tcur = target.charAt(index);

        if (tcur == icur){
            return 1;
        }

        return 0;
    }

    private static String generateResult(int[] result){
        if (result[0] == 0 && result[1] == 0){
            return "꽝";
        }

        StringBuilder sb = new StringBuilder();
        if (result[0] != 0){
            sb.append(result[0]).append("스트라이크");
        }
        if (result[1] != 0){
            sb.append(result[1]).append("볼");
        }

        return sb.toString();
    }
}
