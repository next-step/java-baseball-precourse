package baseball.enums;

public enum GameStatus {

    RESTART("1"),
    EXIT("2"),
    ;

    private String code;

    GameStatus(String code) {
        this.code = code;
    }

    public static GameStatus getCode(String input) {
        if (RESTART.code.equals(input)) {
            return RESTART;
        }
        if (EXIT.code.equals(input)) {
            return EXIT;
        }
        throw new IllegalArgumentException("게임을 새로 시작하려면 1, 2만 입력 가능합니다.");
    }
}
