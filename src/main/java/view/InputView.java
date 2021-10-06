package view;

import nextstep.utils.Console;

public class InputView {

    public String insertBallNumbers() {
        System.out.println();
        System.out.println("숫자를입력해주세요:");
        return Console.readLine();
    }

    public int insertSelectGameContinue() {

        return Integer.parseInt(Console.readLine());
    }
}
