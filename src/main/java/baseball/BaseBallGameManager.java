package baseball;

public class BaseBallGameManager {

    private BaseBallNumber baseBallNumber;

    public BaseBallGameManager() {
        baseBallNumber = new BaseBallNumber();
    }

    public void checkUserAnswer(String userAnswer) {
        validateInteger(userAnswer);
        validateAnswerSize(userAnswer);
    }

    private void validateAnswerSize(String userAnswer) {
        int number = Integer.valueOf(userAnswer);
        if (number < 100 || number >= 1000) {
            System.out.println("ERROR");
            return;
        }
    }

    private void validateInteger(String userAnswer) {
        int number = 0;
        try {
            number = Integer.valueOf(userAnswer);
        } catch (NumberFormatException e) {
            System.out.println("ERROR");
            return;
        }
    }
}
