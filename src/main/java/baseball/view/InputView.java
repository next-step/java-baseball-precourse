package baseball.view;

import nextstep.utils.Console;

public class InputView {

    public static final String PLEASE_ENTER_A_NUMBER = "숫자를 입력해주세요 : ";

    public void startGame() {


    }

    public String inputNumber() {
        System.out.println(PLEASE_ENTER_A_NUMBER);
        String buf = Console.readLine();

        return buf;
    }






}
