package baseball.application;

import static baseball.message.PrintMessage.ASK_THE_USER_TO_ENTER_A_NUMBER;
import static baseball.message.PrintMessage.ASK_THE_USER_TO_ENTER_EXIST_FLAG;
import static baseball.message.PrintMessage.GOT_ALL_THREE_NUMBERS_RIGHT;

import baseball.domain.Computer;
import baseball.domain.JudgementResult;
import baseball.domain.Referee;
import baseball.domain.Player;
import baseball.util.Inputter;
import baseball.util.Printer;

public class BaseBallGameExecutor {
    private static final String GAME_END_FLAG = "2";

    private BaseBallGameExecutor() {

    }

    public static void execute() {
        do {
            play();
        } while (isPlayerExistTheGame());
    }

    private static void play() {
        Computer computer = new Computer();
        JudgementResult judgementResult;
        do {
            Player player = prepareUser();
            Referee referee = new Referee();
            judgementResult = referee.judgement(player.getHasBalls(), computer.getHasBalls());
            Printer.printJudgementResult(judgementResult);
        } while (isNotTheEndOfGame(judgementResult));
    }

    private static Player prepareUser() {
        Printer.print(ASK_THE_USER_TO_ENTER_A_NUMBER.message);
        String userEnteredNumber = Inputter.readNumberStringFromUser();
        return new Player(userEnteredNumber);
    }

    private static boolean isPlayerExistTheGame() {
        Printer.println(ASK_THE_USER_TO_ENTER_EXIST_FLAG.message);
        String userEnteredExistFlag = Inputter.readExistGameFlag();
        return !userEnteredExistFlag.equals(GAME_END_FLAG);
    }

    private static boolean isNotTheEndOfGame(JudgementResult judgementResult) {
        if (judgementResult.isPlayerWin()) {
            Printer.println(GOT_ALL_THREE_NUMBERS_RIGHT.message);
            return false;
        }
        return true;
    }
}
