package baseball.game;

import baseball.common.Message;
import baseball.common.Validator;
import baseball.computer.Computer;
import baseball.referee.Referee;
import camp.nextstep.edu.missionutils.Console;

/**
 * author : hyeongju
 * date : 2022.09.28
 * description : 야구 숫자게임
 */
public class BaseballGame {
    static String COMMAND_START = "1";
    static String COMMAND_END = "2";

    public static void start() {
        playGame();

        boolean isPlay = true;
        while (isPlay) {
            isPlay = selectPlayStatus();
        }
    }

    private static void playGame() {
        boolean isPlay = true;
        Computer com = new Computer();
        Referee referee = new Referee();

        System.out.println(Message.MSG_GAME_START.getMessage());

        while (isPlay) {
            isPlay = playRound(com, referee);
        }
    }

    private static boolean playRound(Computer com, Referee referee) {
        System.out.println(Message.MSG_INPUT_NUMBERS.getMessage());

        String playerNumbers = Console.readLine();
        Validator.isBaseBallValid(playerNumbers);

        return referee.judge(playerNumbers, com.getCorrectAnswer());
    }

    private static boolean selectPlayStatus(){
        System.out.println(Message.MSG_QUESTION_NEW_OR_EXIT.getMessage());
        String inputCommand = Console.readLine();
        if (COMMAND_START.equals(inputCommand)) {
            playGame();
        }
        if (COMMAND_END.equals(inputCommand)) {
            System.out.println(Message.MSG_GAME_EXIT.getMessage());
            return false;
        }

        return true;
    }
}
