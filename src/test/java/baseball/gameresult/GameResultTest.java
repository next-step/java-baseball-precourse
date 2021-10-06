package baseball.gameresult;

import baseball.balls.Ball;
import baseball.balls.Balls;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    private Balls computerBalls;

    @BeforeEach
    public void setUP() {
        Ball firstBall = new Ball(1,2);
        Ball secondBall = new Ball(2,4);
        Ball thirdBall = new Ball(3,6);

        computerBalls = new Balls(Arrays.asList(firstBall,secondBall,thirdBall));
    }


    @Test
    @DisplayName("1스트라이크 2볼일 경우")
    public void oneStrikeTwoBall(){
        Ball firstUserBall = new Ball(1,2);
        Ball secondUserBall = new Ball(2,6);
        Ball thirdUserBall = new Ball(3,4);

        Balls userBalls = new Balls(Arrays.asList(firstUserBall,secondUserBall,thirdUserBall));

        GameResult gameResult = new GameResult(computerBalls, userBalls);

        assertThat(gameResult.getResultMessage()).isEqualTo("1스트라이크 2볼");
    }

    @Test
    @DisplayName("2스트라이크일 경우")
    public void twoStrike(){
        Ball firstUserBall = new Ball(1,2);
        Ball secondUserBall = new Ball(2,4);
        Ball thirdUserBall = new Ball(3,5);

        Balls userBalls = new Balls(Arrays.asList(firstUserBall,secondUserBall,thirdUserBall));

        GameResult gameResult = new GameResult(computerBalls, userBalls);

        assertThat(gameResult.getResultMessage()).isEqualTo("2스트라이크");
    }


    @Test
    @DisplayName("2볼일 경우")
    public void twoBall(){
        Ball firstUserBall = new Ball(1,4);
        Ball secondUserBall = new Ball(2,2);
        Ball thirdUserBall = new Ball(3,5);

        Balls userBalls = new Balls(Arrays.asList(firstUserBall,secondUserBall,thirdUserBall));

        GameResult gameResult = new GameResult(computerBalls, userBalls);

        assertThat(gameResult.getResultMessage()).isEqualTo("2볼");
    }

    @Test
    @DisplayName("낫씽일 경우")
    public void nothing(){
        Ball firstUserBall = new Ball(1,7);
        Ball secondUserBall = new Ball(2,8);
        Ball thirdUserBall = new Ball(3,9);

        Balls userBalls = new Balls(Arrays.asList(firstUserBall,secondUserBall,thirdUserBall));

        GameResult gameResult = new GameResult(computerBalls, userBalls);

        assertThat(gameResult.getResultMessage()).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("게임 종료")
    public void gameEnd(){
        Ball firstUserBall = new Ball(1,2);
        Ball secondUserBall = new Ball(2,4);
        Ball thirdUserBall = new Ball(3,6);

        Balls userBalls = new Balls(Arrays.asList(firstUserBall,secondUserBall,thirdUserBall));

        GameResult gameResult = new GameResult(computerBalls, userBalls);

        gameResult.getResultMessage();

        boolean gameEnd = gameResult.gameEnd("1");
        boolean gameNotEnd = gameResult.gameEnd("2");

        assertThat(gameEnd).isTrue();
        assertThat(gameNotEnd).isFalse();
    }



}
