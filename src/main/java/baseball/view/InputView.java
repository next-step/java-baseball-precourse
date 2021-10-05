package baseball.view;


import nextstep.utils.Console;

import static baseball.common.Constants.EXIT_CONFIRMATION_MESSAGE;

public class InputView {

    public static final String PLEASE_ENTER_A_NUMBER = "숫자를 입력해주세요 : ";
    public static final String rex = "[+-]?\\d*(\\.\\d+)?";


    public String inputNumber() {

        while (true) {
            System.out.print(PLEASE_ENTER_A_NUMBER);
            String sample = Console.readLine();

            if (sample.matches(rex)) {
                return sample;
            }
        }
    }

    public String endingInput() {
        while (true) {
            System.out.println(EXIT_CONFIRMATION_MESSAGE);
            String buf = Console.readLine();
            if (buf.matches(rex)) {
                return buf;
            }
        }
    }


}
