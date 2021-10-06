package baseball.veiw;

import baseball.enums.GameMessage;
import nextstep.utils.Console;

public class ConsoleResponse {

    public static final int ZERO = 0;

    public static String responseMessage(GameMessage gameMessage) {
        System.out.print(gameMessage.getMessage());
        return Console.readLine();
    }

    public static void printMessage(GameMessage gameMessage) {
        System.out.println(gameMessage.getMessage());
    }

    public static void printMessage(int count, GameMessage gameMessage) {
        if (count > ZERO) {
            System.out.print(count + gameMessage.getMessage() + " ");
        }
    }

    public static String responseMessageNext(GameMessage gameMessage) {
        System.out.println(gameMessage.getMessage());
        return Console.readLine();
    }

    public static void printMessage() {
        System.out.println("");
    }
}
