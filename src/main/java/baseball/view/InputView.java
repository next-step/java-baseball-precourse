package baseball.view;

import baseball.BaseBallGameManager;
import nextstep.utils.Console;

public class InputView {

    private static final String RETRY_GAME_ANSWER = "1";
    private static final String END_GAME_ANSWER = "2";

    public static String enterAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        String userAnswer = null;
        try {
            userAnswer = Console.readLine();
            BaseBallGameManager.validate(userAnswer);
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR");
            return enterAnswer();
        }
        return userAnswer;
    }

    public static String enterRetryAnswer() {
        String retryAnswer;
        System.out.println("3개의 숫자를 모두 맞혔습니다. 게임 끝!");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        do {
            retryAnswer = Console.readLine();
        } while (!retryAnswer.equals(END_GAME_ANSWER) && !retryAnswer.equals(RETRY_GAME_ANSWER));
        return retryAnswer;
    }
}
