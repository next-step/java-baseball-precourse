package baseball.game;

import baseball.score.BaseBallScore;
import baseball.ball.ComputerBaseball;
import baseball.ball.UserBaseball;
import org.junit.jupiter.api.Test;

class BaseballPlayTest {
    @Test
    void 게임_시작_테스트(){
        ComputerBaseball computer = new ComputerBaseball();
        UserBaseball person = new UserBaseball("214");
        BaseBallScore score = new BaseBallScore();
        BaseballPlay play = new BaseballPlay(computer,person, score);
        System.out.println(play.getScore());
    }

}