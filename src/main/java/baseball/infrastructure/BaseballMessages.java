package baseball.infrastructure;

public enum BaseballMessages {
    //BaseballService
    GAME_SET("3개의 숫자를 모두 맞히셨습니다! 게임 종료."),
    INPUT_NUMBERS("숫자를 입력해주세요 : ");

    //BaseballResult

    BaseballMessages(String message) {
        this.message = message;
    }
    private String message;

    public String getMessage(){
        return message;
    }
}
