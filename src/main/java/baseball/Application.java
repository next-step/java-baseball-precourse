package baseball;

public class Application {
    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame(new Rule());
        baseBallGame.run();
    }
}
