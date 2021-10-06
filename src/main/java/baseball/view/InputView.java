package baseball.view;

import baseball.domain.UserBaseballNumber;
import baseball.common.Const;
import nextstep.utils.Console;

import java.util.List;

public class InputView {
    public static String getNewGameOrQuitNumber() {
        System.out.println(Const.NEW_GAME_OR_QUIT_MESSAGE);
        return Console.readLine();
    }

    public static List<Integer> inputNumbers() {
        System.out.print(Const.START_MESSAGE);
        try {
            String numbers = Console.readLine();
            return UserBaseballNumber.setUserBaseballNumber(numbers);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return inputNumbers();
        }
    }
}
