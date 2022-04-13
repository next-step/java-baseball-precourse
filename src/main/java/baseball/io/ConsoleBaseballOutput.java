package baseball.io;

import java.io.PrintStream;

public class ConsoleBaseballOutput implements BaseballOutput {
    private final PrintStream output;

    public ConsoleBaseballOutput(PrintStream output) {
        this.output = output;
    }

    @Override
    public void write(String message) {
        output.print(message);
    }

    @Override
    public void writeln(String message) {
        output.println(message);
    }
}
