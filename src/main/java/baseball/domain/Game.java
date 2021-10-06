package baseball.domain;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.*;

public class Game {
    public static final int MIN_NO = 1; // 랜덤 숫자 최소값
    public static final int MAX_NO = 9; // 랜덤 숫자 최대값
    public static final int BALL_MAX_COUNT = 3; // 입력 볼 최대 개수

    List<Integer> computerBalls; // 컴퓨터 볼
    boolean isFinished = false;

    public Game() {}

    // 게임 시작
    public void start() {
        init();
        gameStart();
        gameEnd();
    }

    public void init() {
        this.computerBalls = createThreeRandomBalls();
        System.out.println(computerBalls); // 테스트용 정답 보여주기.
        isFinished = false;
    }

    public void gameStart() {
        while(!isFinished) {
            List<Integer> userBalls = getBalls();
            PlayResult result = play(userBalls);
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

    public int getIsRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(readNumber());
    }

    //== 화면 출력 ==//
    public void displayPlayResult(PlayResult playResult) {
        int strike = playResult.getStrike();
        int ball = playResult.getBall();

        if (strike == 0 && ball == 0) {
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

    //== 게임 결과 리턴 ==//
    // 스트라이크 숫자
    public PlayResult play(List<Integer> userBalls) {
        PlayResult playResult = new PlayResult();
        int max = Math.min(BALL_MAX_COUNT, userBalls.size());
        for (int i = 0; i < max; i++) {
            BallStatus status = checkBalls(userBalls.get(i), i, this.computerBalls);
            playResult.report(status);
        }
        return playResult;
    }

    /** 볼 체크하기!
     * @param userBallNo          볼의 값
     * @param index             볼의 위치
     * @param computerBalls     컴퓨터 볼들
     */
    public BallStatus checkBalls(int userBallNo, int index, List<Integer> computerBalls) {
        if (computerBalls.get(index) == userBallNo) {
            return BallStatus.STRIKE;
        }
        if (computerBalls.contains(userBallNo)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    // 사용자 볼 입력받기
    public List<Integer> getBalls() {
        System.out.print("숫자를 입력해주세요 : ");
        return convertToListOfInteger(readNumber());
    }

    // 숫자만 입력받기
    public String readNumber() {
        String numbers = "init";
        while(!ValidationUtils.checkIsNumber(numbers)) {
            numbers = Console.readLine();
        }
        return numbers;
    }

    // 랜덤한 3개의 숫자 생성
    public List<Integer> createThreeRandomBalls() {
        Set<Integer> balls = new HashSet<>();
        while(balls.size() < 3) {
            balls.add(Randoms.pickNumberInRange(MIN_NO, MAX_NO));
        }
        return new ArrayList<>(balls);
    }

    // 문자열을 Int 배열로 변환
    public List<Integer> convertToListOfInteger(String numbers) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numbers.length(); i++) {
            result.add(Character.getNumericValue(numbers.charAt(i)));
        }
        return result;
    }
}
