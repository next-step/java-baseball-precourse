package baseball.code;

public enum InGameText {
    ENTER_VALUE("숫자를 입력해주세요. : "),
    ENDGAME("3개의 숫자를 모두 맞히셨습니다! 게임 끝"),
    DECIDE_RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String inGameText;

    InGameText(String inGameText) {
        this.inGameText = inGameText;
    }

    public String getInGameText() {
        return this.inGameText;
    }

}
