package view;

import exception.GameException;

public enum UserCommand {
    START, EXIT;

    public static UserCommand of(int num) {
        if (num == 1) {
            return UserCommand.START;
        }
        if (num == 2) {
            return UserCommand.EXIT;
        }
        throw new GameException("UserCommand 생성 실패");
    }
}
