package baseball;

public class Controller {

    private static String REGEX_PATTERN = "[1-9]{3}";
    private static String END_GAME = "2";

    private Model model = new Model();

    void validateNumber(String number) {
        if (!number.matches(REGEX_PATTERN)) {
            throw new IllegalArgumentException();
        }
        this.model.setInput(number);
    }

    String checkAnswer() {
        return model.getHint();
    }

    boolean finishGame(String endInput) {
        if (endInput.equals(END_GAME)) {
            return true;
        }
        this.model = new Model();
        return false;
    }

}
