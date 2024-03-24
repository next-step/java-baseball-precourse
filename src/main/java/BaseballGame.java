public class BaseballGame {
    final private BaseballView baseballView;
    final private BaseballController baseballController;
    final private BaseballScore baseballScore;

    private boolean gameExited = false;

    public BaseballGame(BaseballView baseballView, BaseballController baseballController, BaseballScore baseballScore) {
        this.baseballView = baseballView;
        this.baseballController = baseballController;
        this.baseballScore = baseballScore;
    }

    public void start() {
        baseballScore.resetNumbers();

        while (!gameExited) {
            tick();
        }
    }

    private void handleExitOrRestart(boolean exit) {
        if (exit) {
            gameExited = true;
            return;
        }

        baseballScore.resetNumbers();
    }

    private void tick() {
        baseballView.printTurnInputMessage();
        int[] inputNumbers = baseballController.getInput();
        TurnResult result = baseballScore.calculateResult(baseballScore.numbers, inputNumbers);
        baseballView.printScore(result);

        if (result.strike == 3) {
            baseballView.printWin();
            baseballView.printExitOrRestartMessage();

            boolean exit = baseballController.getExitOrRestartInput();

            handleExitOrRestart(exit);
        }
    }
}
