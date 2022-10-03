package baseball.view;

public interface BaseballView {

    String READLINE_MESSAGE = "숫자를 입력해주세요 : ";
    String COMPLETE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    String RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    String RETRY = "1";

    String readLine();

    void printResult(String result);

    void printCompleteMessage();

    boolean completeReadLine();
}
