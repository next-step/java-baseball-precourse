package baseball;

import nextstep.utils.Console;

public class BaseBallGameManager {


    private BaseBallNumber baseBallNumber;

    private boolean isFinished = false;
    private static final String RETRY_GAME_ANSWER = "1";
    private static final String END_GAME_ANSWER = "2";

    public BaseBallGameManager(int number) {
        baseBallNumber = new BaseBallNumber(number);
    }

    public BaseBallGameManager() {
        baseBallNumber = new BaseBallNumber();
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void checkUserAnswer(String userAnswer) {
        validateInteger(userAnswer);
        validateAnswerSize(userAnswer);
        enterRetryGame(baseBallNumber.isCorrectAnswer(Integer.valueOf(userAnswer)));
    }

    private void enterRetryGame(boolean isFinished) {
        if (isFinished) {
            System.out.println("3개의 숫자를 모두 맞혔습니다. 게임 끝!");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            prepareNextGame();
        }
    }

    private void prepareNextGame() {
        String retryAnswer = enterRetryAnswer();
        if (retryAnswer.equals(END_GAME_ANSWER)) {
            return;
        }
        if (retryAnswer.equals(RETRY_GAME_ANSWER)) {
            isFinished = false;
            baseBallNumber = new BaseBallNumber();
        }
    }

    private String enterRetryAnswer() {
        String retryAnswer;
        do {
            retryAnswer = Console.readLine();
        } while (!retryAnswer.equals(END_GAME_ANSWER) && !retryAnswer.equals(RETRY_GAME_ANSWER));
        return retryAnswer;
    }

    private void validateAnswerSize(String userAnswer) {
        int number = Integer.valueOf(userAnswer);
        if (number < 100 || number >= 1000) {
            System.out.println("ERROR");
            return;
        }
    }

    private void validateInteger(String userAnswer) {
        try {
            Integer.valueOf(userAnswer);
        } catch (NumberFormatException e) {
            System.out.println("ERROR");
            return;
        }
    }
}
