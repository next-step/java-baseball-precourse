package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 콘솔 입력
 */
public class GameInputView {

    public static String readNumber() {
        return readLine();
    }

    /**
     * 추가 게임을 하고자 하는지 콘솔 입력 통해 확인
     * @return 추가 게임을 하고자 할 경우 "1" 반환, 종료하고자 할 경우 "2" 반환
     */
    public static String readWantGameOver() {
        String gameOver = readLine();
        validateWantGameOver(gameOver);
        return gameOver;
    }

    /**
     * 추가 게임 여부값 validation 체크
     * @param gameOver "1" 또는 "2"일 경우만 valid
     */
    private static void validateWantGameOver(String gameOver) {
        if(!"1".equals(gameOver) && !"2".equals(gameOver)) {
            throw new IllegalArgumentException("1 또는 2만 입력 가능합니다.");
        }
    }
}
