package baseball.controller;

import baseball.Computer;
import baseball.GameProcessor;
import baseball.MessagePrinter;
import baseball.Player;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballGame {

    public static void start() {

        boolean isStart = true;
        while (isStart) {
            Computer computer = new Computer();
            computer.generateThreeNumbers(); // TODO : 고민 : Computer 클래스의 main() 메서드로 만들 수 있을까?

            isStart = init(computer);
        }
        terminate();
    }

    public static boolean init(Computer computer) {
        boolean isThreeStrike = false;
        Player player = new Player();
        GameProcessor gameProcessor = new GameProcessor();

        while (!isThreeStrike) {
            player.drawNumbers();
            isThreeStrike = gameProcessor.playGame(computer.computerNumberList, player.inputs);
        }
        return retry();
    }

    private static boolean retry() {

        final String RETRY = "1";
        final String TERMINATE = "2";

        MessagePrinter.printAskRetry();
        String continueFlag = readLine();

        if (continueFlag.equals(RETRY)) {
            MessagePrinter.printRetry();
            return true;
        }

        if (continueFlag.equals(TERMINATE)) {
            return false;
        }

        throw new IllegalArgumentException();
    }

    public static void terminate() {
        MessagePrinter.printTerminate();
    }
}
