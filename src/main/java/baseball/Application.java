package baseball;

import static baseball.constant.BaseballNumberEnum.MAX_DIGIT;
import static baseball.constant.BaseballStringEnum.END_GAME;
import static baseball.constant.BaseballStringEnum.END_GAME_NOTICE;
import static baseball.constant.BaseballStringEnum.GET_THREE_STRIKES_NOTICE;
import static baseball.constant.BaseballStringEnum.NEW_GAME;
import static baseball.constant.BaseballStringEnum.NEW_GAME_OR_END_GAME;

import baseball.game.Baseball;
import baseball.util.Util;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static Integer DIGIT_FOR_GAME = MAX_DIGIT.intValue;
    public static final Util util = new Util();

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String flg = NEW_GAME.label;
        while (flg.equals(NEW_GAME.label)) {
            Baseball baseball = util.getBaseballWithRandomNumber();
            baseball.runGame(false);
            System.out.printf(GET_THREE_STRIKES_NOTICE.label, DIGIT_FOR_GAME);
            System.out.printf(NEW_GAME_OR_END_GAME.label, NEW_GAME.label, END_GAME.label);
            flg = Console.readLine();
        }
        System.out.println(END_GAME_NOTICE.label);
    }
}
