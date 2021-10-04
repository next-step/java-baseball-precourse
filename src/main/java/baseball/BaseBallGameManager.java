package baseball;

public class BaseBallGameManager {


    private BaseBallNumber baseBallNumber;

    private boolean isFinished = false;
    public static final String RETRY_GAME_ANSWER = "1";
    public static final String END_GAME_ANSWER = "2";

    public BaseBallGameManager(int number) {
        baseBallNumber = new BaseBallNumber(number);
    }

    public BaseBallGameManager() {
        baseBallNumber = new BaseBallNumber();
    }

    public boolean isFinished() {
        return isFinished;
    }

    public boolean checkUserAnswer(String userAnswer) {
        isFinished = baseBallNumber.makeAnswerResult(Integer.valueOf(userAnswer)).isCorrectAnswer();
        return baseBallNumber.makeAnswerResult(Integer.valueOf(userAnswer)).isCorrectAnswer();
    }

    public AnswerResult findAnswerResult(String userAnswer) {
        return baseBallNumber.makeAnswerResult(Integer.valueOf(userAnswer));
    }


    public void prepareNextGame(String retryAnswer) {
        if (retryAnswer.equals(END_GAME_ANSWER)) {
            return;
        }
        if (retryAnswer.equals(RETRY_GAME_ANSWER)) {
            isFinished = false;
            baseBallNumber = new BaseBallNumber();
        }
    }

    public static void validate(String userAnswer) {
        validateInteger(userAnswer);
        validateAnswerSize(userAnswer);
    }


    private static void validateAnswerSize(String userAnswer) {
        int number = Integer.valueOf(userAnswer);
        if (number < 100 || number >= 1000) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateInteger(String userAnswer) {
        try {
            Integer.valueOf(userAnswer);
        } catch (NumberFormatException e) {
            return;
        }
    }
}
