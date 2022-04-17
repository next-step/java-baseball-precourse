package baseball;

public class Application {
    public static void main(String[] args) {
        boolean result;

        do {
            result = new BaseBallGame().run();
        } while(result);
    }
}
