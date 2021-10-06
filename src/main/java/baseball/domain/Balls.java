package baseball.domain;

import baseball.utils.ValidationUtils;
import baseball.view.GameUI;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {

    List<Integer> computerBalls;

    public Balls() {
        this.computerBalls = createThreeRandomBalls();
    }

    //== 게임 결과 리턴 ==//
    // 스트라이크 숫자
    public PlayResult play(List<Integer> userBalls) {
        PlayResult playResult = new PlayResult();
        int max = Math.min(Game.BALL_MAX_COUNT, userBalls.size());
        for (int i = 0; i < max; i++) {
            BallStatus status = checkBalls(userBalls.get(i), i, this.computerBalls);
            playResult.report(status);
        }
        return playResult;
    }

    /** 볼 체크하기!
     * @param userBallNo        볼의 값
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

    // 랜덤한 3개의 숫자 생성
    public List<Integer> createThreeRandomBalls() {
        Set<Integer> balls = new HashSet<>();
        while(balls.size() < 3) {
            balls.add(Randoms.pickNumberInRange(Game.MIN_NO, Game.MAX_NO));
        }
        return new ArrayList<>(balls);
    }
}
