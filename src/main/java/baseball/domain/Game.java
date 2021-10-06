package baseball.domain;

import baseball.utils.ValidationUtils;
import nextstep.utils.Console;

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
            displayPlayResult(result);
        }
    }

    public void gameEnd() {
        int isRestart = getIsRestart();
        if (isRestart == 1) {
            start();
        }
    }

    // 1 : 재시작 / 2 : 종료 입력받기
    public int getIsRestart() {
        String numbers = getIsRestartValue();

        while(!ValidationUtils.checkIsNumber(numbers)
            || !ValidationUtils.checkLength(numbers, 1)) {
            numbers = balls.getBallsValue();
        }
        return Character.getNumericValue(numbers.charAt(0));
    }

    public String getIsRestartValue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    //== 화면 출력 ==//
    public void displayPlayResult(PlayResult playResult) {
        int strike = playResult.getStrike();
        int ball = playResult.getBall();

        if (playResult.isNothing()) {
            System.out.println("낫싱");
            return;
        }
        String message = "";
        if (strike > 0) {
            message += strike + "스트라이크 ";
        }
        if (ball > 0) {
            message += ball + "볼 ";
        }
        System.out.println(message);
    }
}
