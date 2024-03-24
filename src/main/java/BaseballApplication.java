public class BaseballApplication {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(new NumberGenerator(), new BaseballView());

        baseballGame.run();
    }
}
