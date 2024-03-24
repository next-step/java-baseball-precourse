package baseball.domain;

public enum GameCommand {
    START("1"), EXIT("2");

    final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand from(String input) {
        for (GameCommand gameCommand : GameCommand.values()) {
            if (gameCommand.command.equals(input)) {
                return gameCommand;
            }
        }
        throw new IllegalArgumentException("올바르지 않은 명령어입니다.");
    }

}
