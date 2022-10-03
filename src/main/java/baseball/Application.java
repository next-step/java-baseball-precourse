package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static boolean handleGameSuccess(GameBrokerController controller) {
        GameConsoleView.printSuccessMessage();
        GameConsoleView.printContinueAskInput();
        String continueOption = readLine();
        boolean willContinue = controller.willContinue(continueOption);
        GameBotModel.getInstance().setCompleted(willContinue);
        return willContinue;
    }
    public static boolean trySingleGame(GameBrokerController controller) {
        boolean willContinue = false;
        GameConsoleView.printInputRequired();
        String input = readLine();
        GameResult[] gameResult = controller.run(input);
        GameConsoleView.printInputResult(gameResult);
        boolean allStrikes = GameResult.allMatch(gameResult, GameResult.STRIKE);
        if (allStrikes) {
            willContinue = handleGameSuccess(controller);
        }
        return !allStrikes || willContinue;
    }
    public static void main(String[] args) {
        GameBrokerController controller = new GameBrokerController();
        boolean onGaming = true;

        while (onGaming) {
            onGaming = trySingleGame(controller);
        }
        GameConsoleView.printGameFinished();
    }
}
