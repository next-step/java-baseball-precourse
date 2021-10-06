package baseball.domain;

import baseball.utils.ValidationUtils;
import baseball.view.GameUI;

import java.util.List;

public class Game {
    public static final int MIN_NO = 1; // 랜덤 숫자 최소값
    public static final int MAX_NO = 9; // 랜덤 숫자 최대값
    public static final int BALL_MAX_COUNT = 3; // 입력 볼 최대 개수

    Balls balls = new Balls();

    //== game 변수 ==//
    boolean isFinished = false;

    public Game() {}

    // 게임 시작
    public void start() {
        init();
        gameStart();
        gameEnd();
    }

    public void init() {
        balls = new Balls();
        isFinished = false;
    }

    public void gameStart() {
        while(!isFinished) {
            List<Integer> userBalls = balls.getBalls();
            PlayResult result = balls.play(userBalls);
            isFinished = result.isGameEnd();
            GameUI.displayPlayResult(result);
        }
    }

    public void gameEnd() {
        int isRestart = getIsRestart();
        if (isRestart == 1) {
            start();
        }
        GameUI.gameEndMessage();;
    }

    // 1 : 재시작 / 2 : 종료 입력받기
    public int getIsRestart() {
        String numbers = GameUI.getIsRestartValue();

        while(!ValidationUtils.checkIsNumber(numbers)
            || !ValidationUtils.checkLength(numbers, 1)) {
            numbers = GameUI.getIsRestartValue();
        }
        return Character.getNumericValue(numbers.charAt(0));
    }
}
