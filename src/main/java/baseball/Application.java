package baseball;

import nextstep.utils.Randoms;

public class Application {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;
    private static final int DIGIT_SIZE = 3;

    public static void main(String[] args) {
        String target = generateNumberString();

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
}
