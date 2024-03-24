public class BaseballApplication {
    public static void main(String[] args) {
        BaseballView baseballView = new BaseballView();
        BaseballController baseballController = new BaseballController(baseballView);
        BaseballScore baseballScore = new BaseballScore();
        BaseballGame baseballGame = new BaseballGame(baseballView, baseballController, baseballScore);

        baseballGame.start();
    }
}