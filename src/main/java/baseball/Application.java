package baseball;

import baseball.service.executor.BaseballGameExecutor;

public class Application {

    public static void main(String[] args) {

        BaseballGameExecutor executor = new BaseballGameExecutor();
        executor.execute();
    }
}
