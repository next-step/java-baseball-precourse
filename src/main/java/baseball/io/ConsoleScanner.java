package baseball.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleScanner implements Scanner {
    @Override
    public String readLine() {
        return Console.readLine();
    }
}
