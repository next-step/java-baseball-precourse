package baseball;

public class Application {
    public static void main(String[] args) {
        Baseball baseball = new Baseball();
        while (baseball.isRunnable()) {
            baseball.run();
        }
    }
}
