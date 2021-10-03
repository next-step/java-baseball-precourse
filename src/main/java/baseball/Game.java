package baseball;

public class Game {
    private final int START_INCLUSIVE = 0;
    private final int END_INCLUSIVE = 9;

    private final int PICK_NUMBER_COUNT = 3;

    private final NumberGenerator numberGenerator;
    private final GameResult gameResult;

    private final GameConsoleInput gameConsoleInput = new GameConsoleInput();

    private String systemNumbers;

    public Game() {
        numberGenerator = new NumberGenerator(START_INCLUSIVE, END_INCLUSIVE);
        gameResult = new GameResult(PICK_NUMBER_COUNT);
    }

    public void play() {
        generateSystemNumberIfNull();
        boolean isContinue = true;
        while (isContinue) {
            String inputNumber = gameConsoleInput.getInputNumber();
            gameResult.compare(systemNumbers, inputNumber);
            Message.printResultMessage(gameResult.getStrikeCount(), gameResult.getBallCount());
            isContinue = !gameResult.isFinish();
        }
        over();
    }

    private void over() {
        final String RESTART_KEY = "1";
        String inputKey = gameConsoleInput.getInputKey();
        if(RESTART_KEY.equals(inputKey)) {
            play();
        }
    }

    private void generateSystemNumberIfNull() {
        this.systemNumbers = numberGenerator.generateNumbers(PICK_NUMBER_COUNT);
    }

}
