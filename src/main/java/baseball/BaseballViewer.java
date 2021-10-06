package baseball;

import nextstep.utils.Console;

public class BaseballViewer {

    private final static String RESTART = "1";
    private final static String QUIT = "2";

    public String getUserInput() {
        System.out.println("숫자를 입력해주세요. : ");
        return String.valueOf(Console.readLine());
    }

}
