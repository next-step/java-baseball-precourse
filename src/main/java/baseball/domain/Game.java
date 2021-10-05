package baseball.domain;

import nextstep.utils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Game {
    public static final int MIN_NO = 1; // 랜덤 숫자 최소값
    public static final int MAX_NO = 9; // 랜덤 숫자 최대값

    Set<Integer> computerBalls = new HashSet<>(); // 컴퓨터 볼

    public Game() {}

    // 게임 시작
    public void start() {
        this.computerBalls = createThreeRandomBalls();
    }

    // 랜덤한 3개의 숫자 생성
    public Set<Integer> createThreeRandomBalls() {
        Set<Integer> balls = new HashSet<>();
        while(balls.size() < 3) {
            balls.add(Randoms.pickNumberInRange(1, 9));
        }
        return balls;
    }
}
