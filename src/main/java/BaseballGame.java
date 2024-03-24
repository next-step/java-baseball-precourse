public class BaseballGame {
    private final int LENGTH = 3;
    private final int MIN_VALUE = 1;
    private final int MAX_VALUE = 9;
    private final NumberGenerator numberGenerator;
    private final BaseballView baseballView;
    private boolean isTerminated;
    private int[] answerNumbers;

    BaseballGame(NumberGenerator numberGenerator, BaseballView baseballView) {
        this.numberGenerator = numberGenerator;
        this.baseballView = baseballView;

        this.isTerminated = false;
    }

    public void run() {
        initialize();
        while (!isTerminated) {
            String userNumber = baseballView.inputUserNumber();
            if (!baseballView.validateUserNumber(userNumber, LENGTH, MIN_VALUE, MAX_VALUE)) {
                baseballView.printError();
                continue;
            }
            int[] userNumbers = baseballView.refineUserNumber(userNumber);

            BaseballScore score = BaseballScore.calculateScore(userNumbers, answerNumbers);
            baseballView.printResult(score);

            if (checkGameEnd(score)) {
                handleGameEnd();
            }
        }
    }

    private void handleGameEnd() {
        baseballView.printWinMessage(LENGTH);
        isTerminated = baseballView.askGameEnd();
        if (!isTerminated) {
            initialize();
        }
    }

    private void initialize() {
        answerNumbers = numberGenerator.generateNumbersBetween(LENGTH, MIN_VALUE, MAX_VALUE);
    }

    private boolean checkGameEnd(BaseballScore score) {
        return score.getStrikeCount() == LENGTH;
    }
}
