package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class Application {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;
    private static final int DIGIT_SIZE = 3;
    private static final String ONLY_DIGIT = "\\d+";

    public static void main(String[] args) {
        play();
        while (isNextGameAvailable()){
            play();
        }
    }

    private static void play(){
        String target = generateNumberString();
        String input = "";
        while (!target.equals(input)){
            input = getUserInput();
            int[] counted = count(target, input);
            System.out.println(generateResult(counted));
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    private static String generateNumberString(){
        StringBuilder value = new StringBuilder();
        while (value.length() < DIGIT_SIZE){
            String number = String.valueOf(Randoms.pickNumberInRange(START_RANGE, END_RANGE));
            appendIfUnique(value, number);
        }

        return value.toString();
    }

    private static void appendIfUnique(StringBuilder value, String number){
        if (value.indexOf(number) == -1){
            value.append(number);
        }
    }

    private static String getUserInput(){
        System.out.println("숫자를 입력해 주세요: ");
        String input = Console.readLine();
        if (!validateInput(input)){
            System.out.println("[ERROR] 1부터 9까지 숫자 3개만 입력해주세요. (예시) 123");
        }

        return input;
    }

    private static boolean validateInput(String input){
        if (input.matches(ONLY_DIGIT) && input.length() == 3 && !input.contains("0")){
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
            return "낫싱";
        }

        StringBuilder sb = new StringBuilder();
        if (result[0] != 0){
            sb.append(result[0]).append("스트라이크").append(" ");
        }
        if (result[1] != 0){
            sb.append(result[1]).append("볼");
        }

        return sb.toString();
    }

    private static boolean isNextGameAvailable(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        int value = Integer.parseInt(input);
        if (value == 1){
            return true;
        }
        if (value != 2){
            System.out.println("[ERROR] 숫자 1과 2 중에서 입력해주세요. 게임은 종료됩니다.");
        }

        return false;
    }
}
