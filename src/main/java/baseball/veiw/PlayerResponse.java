package baseball.veiw;

import baseball.enums.GameMessage;

public class PlayerResponse {

    private int value;
    private GameMessage message;

    public PlayerResponse(int value, GameMessage message) {
        this.value = value;
        this.message = message;
    }

    public PlayerResponse(GameMessage message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return message.equals(GameMessage.SUCCESS_RESPONSE);
    }

    public void errorPrint() {
        ConsoleResponse.printMessage(this.message);
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "PlayerResponse{" +
                "value=" + value +
                ", message=" + message +
                '}';
    }
}
