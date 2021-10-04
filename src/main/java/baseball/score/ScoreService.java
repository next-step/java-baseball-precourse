package baseball.score;

import baseball.model.Ball;

import java.util.ArrayList;

public interface ScoreService {
    /**
     * 게임 시작
     */
    void start();

    /**
     * 볼 카운트 생성
     *
     * @param ballCount 볼 카운트를 담을 배열
     * @return 볼 카운트
     */
    ArrayList<String> createBallCount(ArrayList<String> ballCount);

    /**
     * 볼 입력 값을 받음
     */
    ArrayList<String> submit();

    /**
     * 입력 받은 볼 카운트 검증
     *
     * @param inputBalls 입력 값
     */
    ArrayList<String> validationSelectBalls(String inputBalls);

    Ball compareValue(Ball ballCount, ArrayList<String> arr, ArrayList<String> anotherArr);

    /**
     * 재시작
     */
    void restart();

    /**
     * 게임 종료
     */
    void finish();
}
