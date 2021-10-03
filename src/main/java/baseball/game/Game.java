package baseball.game;

import baseball.game.console.GameOverConsole;
import baseball.game.console.GamePlayConsole;
import baseball.utils.Message;
import baseball.utils.NumberGenerator;

public class Game {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;

    private static final int PICK_NUMBER_COUNT = 3;

    private static final int PLAY_INPUT_NUMBER_LENGTH = 3;
    private static final int OVER_INPUT_NUMBER_LENGTH = 1;

    private final NumberGenerator numberGenerator;
    private final GameResult gameResult;

    private final GamePlayConsole gamePlayConsole;
    private final GameOverConsole gameOverConsole;

    private String systemNumbers;

    public Game() {
        numberGenerator = new NumberGenerator(START_INCLUSIVE, END_INCLUSIVE);
        gameResult = new GameResult(PICK_NUMBER_COUNT);
        gamePlayConsole = new GamePlayConsole(PLAY_INPUT_NUMBER_LENGTH);
        gameOverConsole = new GameOverConsole(OVER_INPUT_NUMBER_LENGTH);
    }

    public void play() {
        generateSystemNumberIfNull();
        boolean isContinue = true;
        while (isContinue) {
            String inputNumber = gamePlayConsole.getInputValue();
            gameResult.compare(systemNumbers, inputNumber);
            Message.printResultMessage(gameResult.getStrikeCount(), gameResult.getBallCount());
            isContinue = !gameResult.isFinish();
        }
        over();
    }

    private void over() {
        final String RESTART_KEY = "1";
        String inputKey = gameOverConsole.getInputValue();
        if(RESTART_KEY.equals(inputKey)) {
            play();
        }
    }

    private void generateSystemNumberIfNull() {
        this.systemNumbers = numberGenerator.generateNumbers(PICK_NUMBER_COUNT);
        System.err.println(systemNumbers);
    }

}
