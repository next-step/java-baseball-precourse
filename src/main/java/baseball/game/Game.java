package baseball.game;

import baseball.game.console.GameOverConsole;
import baseball.game.console.GamePlayConsole;
import baseball.game.constant.GameRule;
import baseball.utils.NumberGenerator;

public class Game {
    private final NumberGenerator numberGenerator;
    private final GameResult gameResult;

    private final GamePlayConsole gamePlayConsole;
    private final GameOverConsole gameOverConsole;

    private String systemNumbers;

    public Game() {
        numberGenerator = new NumberGenerator(GameRule.START_INCLUSIVE, GameRule.END_INCLUSIVE);
        gameResult = new GameResult(GameRule.PICK_NUMBER_COUNT);
        gamePlayConsole = new GamePlayConsole(GameRule.PLAY_INPUT_NUMBER_LENGTH);
        gameOverConsole = new GameOverConsole(GameRule.OVER_INPUT_NUMBER_LENGTH);
    }

    public void play() {
        generateSystemNumbersIfNull();
        boolean isContinue = true;
        while (isContinue) {
            String inputNumbers = gamePlayConsole.getInputValue();
            gameResult.compare(systemNumbers, inputNumbers);
            Message.printResultMessage(gameResult.getStrikeCount(), gameResult.getBallCount());
            isContinue = !gameResult.isFinish();
        }
        over();
    }

    private void over() {
        String inputKey = gameOverConsole.getInputValue();
        if(GameRule.RESTART_INPUT_KEY.equals(inputKey)) {
            play();
        }
    }

    private void generateSystemNumbersIfNull() {
        this.systemNumbers = numberGenerator.generateNumbers(GameRule.PICK_NUMBER_COUNT);
    }

}
