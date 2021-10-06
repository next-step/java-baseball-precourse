package baseball.domain;

import baseball.utils.ValidationUtils;
import baseball.view.GameUI;

import java.util.ArrayList;
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
            List<Integer> userBalls = getBalls();
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
        GameUI.gameEndMessage();
    }

    // 사용자 볼 입력받기
    public List<Integer> getBalls() {
        String numbers = GameUI.getBallsValue();

        // 최소 3자리 이상 입력 받아야 됨
        // 숫자만 입력받아야 한다.
        while(!validateNumber(numbers, 3)) {
            numbers = GameUI.getBallsValue();
        }

        return convertToListOfInteger(numbers);
    }

    // 문자열을 Int 배열로 변환
    public List<Integer> convertToListOfInteger(String numbers) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numbers.length(); i++) {
            result.add(Character.getNumericValue(numbers.charAt(i)));
        }
        return result;
    }

    // 1 : 재시작 / 2 : 종료 입력받기
    public int getIsRestart() {
        String numbers = GameUI.getIsRestartValue();

        while(!validateNumber(numbers, 1)) {
            numbers = GameUI.getIsRestartValue();
        }
        return Character.getNumericValue(numbers.charAt(0));
    }

    public boolean validateNumber(String numbers, int length) {
        if (!ValidationUtils.checkIsNumber(numbers)) {
            GameUI.displayErrorMessage("숫자만 입력해주세요.");
            return false;
        }
        if (!ValidationUtils.checkLength(numbers, length)) {
            GameUI.displayErrorMessage(String.format("공백을 제외한 최소 %d자리 이상의 숫자를 입력해주세요.", length));
            return false;
        }
        if (ValidationUtils.containsZero(numbers)
                || ValidationUtils.isDuplicate(numbers)) {
            GameUI.displayErrorMessage("숫자는 0을 제외한, 중복되지 않는 1~9사이의 숫자를 입력해주세요.");
            return false;
        }
        return true;
    }
}
