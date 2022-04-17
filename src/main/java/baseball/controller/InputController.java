package baseball.controller;

import camp.nextstep.edu.missionutils.Console;

public class InputController {

    public String inputNumbers() {
        baseball.view.Console console = new baseball.view.Console();
        console.displayTypeNumber();
        try {
            return Console.readLine();
        } catch (Exception ex) {
            throw new IllegalArgumentException("게임 종료");
        }
    }

    public Integer inputOptions() {
        int result = 0;
        do {
            try {
                result = Integer.parseInt(Console.readLine());
                isOptionInRange(result);
            } catch (NumberFormatException ex) {
                System.out.print("invalid option. please type again : ");
            }
        } while (result <= 0 || result >= 3);

        return result;
    }

    private void isOptionInRange(int result) {
        if (result <= 0 || result >= 3) {
            System.out.print("invalid option. please type again : ");
        }
    }
}
