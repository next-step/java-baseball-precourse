package baseball;

import baseball.domain.BaseBallGame;
import baseball.domain.BassBallNumberGenerator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        List<Integer> answer;
        do {
            answer = BassBallNumberGenerator.createRandomNumbers();
        } while(BaseBallGame.playBall(answer));
    }
}
