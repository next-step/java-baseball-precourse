package baseball.view;

public class ConsolePrinter {
    public static void printConsoleMsg(Messages msg) {
        System.out.print(msg.getMsg());
    }

    public static void printConsoleMsg(String msg) {
        System.out.print(msg);
    }
}
