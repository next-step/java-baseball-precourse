package baseball;

public class Application {
    public static void main(String[] args) {
        BaseballView baseballView = new BaseballView(new BaseballController(new BaseballService()));
        baseballView.startGame();
    }
}
