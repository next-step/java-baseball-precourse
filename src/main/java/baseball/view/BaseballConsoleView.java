package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class BaseballConsoleView implements BaseballView {

    @Override
    public String readLine() {
        System.out.print(READLINE_MESSAGE);
        return Console.readLine();
    }

    @Override
    public void printResult(String result) {
        System.out.println(result);
    }

    @Override
    public void printCompleteMessage() {
        System.out.println(COMPLETE_MESSAGE);
        System.out.println(RETRY_MESSAGE);
    }

    @Override
    public boolean completeReadLine() {
        return !RETRY.equals(Console.readLine());
    }

}
