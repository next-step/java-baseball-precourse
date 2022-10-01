package baseball.game;

import baseball.io.Printer;
import baseball.context.RestartPolicy;
import baseball.io.Scanner;

public class GameRestartPolicy implements RestartPolicy {

    private final Printer printer;
    private final Scanner scanner;

    public GameRestartPolicy(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    @Override
    public void restart(boolean canRestart, Runnable restartSignal, Runnable exitSignal) {
        if (canRestart) {
            printer.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            printer.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String signal = scanner.readLine();
            onSignal("1".equals(signal), restartSignal);
            onSignal("2".equals(signal), exitSignal);
        }
    }

    private void onSignal(boolean on, Runnable signal) {
        if (on) {
            signal.run();
        }
    }
}
