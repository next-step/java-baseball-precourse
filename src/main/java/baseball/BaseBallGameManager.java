package baseball;

import nextstep.utils.Console;

public class BaseBallGameManager {

    private BaseBallNumber baseBallNumber;

    private boolean isFinished = false;

    public BaseBallGameManager() {
        baseBallNumber = new BaseBallNumber();
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void checkUserAnswer(String userAnswer) {
        validateInteger(userAnswer);
        validateAnswerSize(userAnswer);
        isFinished = baseBallNumber.isCorrectAnswer(Integer.valueOf(userAnswer));
        enterRetryGame(isFinished);
    }

    private void enterRetryGame(boolean isFinished) {
        if (isFinished) {
            System.out.println("3개의 숫자를 모두 맞혔습니다. 게임 끝!");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            String retryAnswer = Console.readLine();
            prepareNextGame(retryAnswer);
        }
    }

    private void prepareNextGame(String retryAnswer) {
        if (retryAnswer.equals("2")) {
            return;
        }
        isFinished = false;
        baseBallNumber = new BaseBallNumber();
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
