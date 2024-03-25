package NumberBaseball.view;

import NumberBaseball.model.BaseballConfig;

public class ViewMessage {
    public static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    public static final String NOTHING = "낫싱";
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String GAME_END = BaseballConfig.BASEBALL_NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 끝";
    public static final String RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
}
