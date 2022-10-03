package baseball;

public class Application {

    public static void main(String[] args) {
        Balls balls = new Balls();
        boolean end = false;
        while (!end) {
            final String input = InputView.show();
            validateInputLength(input);
            validateInputType(input);
            PlayResult result = balls.compare(input);
            end = OutputView.show(result, balls);
        }
    }

    private static void validateInputLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력 값의 길이가 적절하지 않습니다.");
        }
    }

    private static void validateInputType(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("입력은 숫자만 가능합니다.");
        }
    }
}
