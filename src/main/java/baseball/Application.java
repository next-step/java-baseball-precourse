package baseball;

import baseball.domain.Computer;
import baseball.domain.Gamer;
import baseball.domain.Umpire;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        do {
            Computer computer = ready();
            playBall(computer);
        } while (!exitOrRestart());
    }

    public static Computer ready() {
        return new Computer();
    }

    public static void playBall(Computer computer) {
        boolean offFlag = false;
        do {
            Integer[] balls = InputView.inputBalls();
            Umpire umpire = new Umpire(computer, new Gamer(balls)).called();
            if (umpire.isThreeStrike()) offFlag = true;
            OutputView.printCall(umpire);
        } while (!offFlag);
    }

    public static boolean exitOrRestart() {
        OutputView.printWinningMessage();
        return InputView.inputExitOrRestart();
    }
}
