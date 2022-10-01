package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        applicationStart(true);
    }
    private static void applicationStart(boolean continueFlag) {
        while (continueFlag){
            Game game = new Game();
            game.init();
            game.generateCounterBaseballs();
            game.guessCounterBaseballs();
            continueFlag = game.isRestartGame();
        }
    }
}
