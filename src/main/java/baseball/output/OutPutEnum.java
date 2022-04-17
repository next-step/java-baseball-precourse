package baseball.output;

public enum OutPutEnum {
    NOTHING("낫싱"),
    GAME_MESSAGE("숫자를 입력해주세요 : "),
    RESTART_MESSAGE("재시작 하시겠습니까? 1)재시작 2)종료"),
    END_MESSAGE("게임 종료");

    private final String value;

    OutPutEnum(String value) {
        this.value = value;
    }

    public String text() {
        return this.value;
    }
}
