package baseball.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleBaseballInput implements BaseballInput {
    @Override
    public String read() {
        return Console.readLine();
    }
}
