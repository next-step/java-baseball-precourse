package baseball.constants;

import lombok.Getter;

@Getter
public enum BaseballGameMessage {

    NUMBER_INPUT("숫자를 입력해주세요 : "),
    END_GAME("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART_GAME("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    BaseballGameMessage(String message) {
        this.message = message;
    }

    private String message;

}
