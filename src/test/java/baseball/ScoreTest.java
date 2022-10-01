package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    private int BallScore;
    private int StrikeScore;

    Score testScore = new Score(1,1);
    Baseball testBaseball = new Baseball(1,2,3);
    Baseball userBaseball = new Baseball(1, 3, 0);

    @BeforeEach
    void setup(){
        BallScore=0;
        StrikeScore=0;

    }

    @Test
    void countStrike() {


        if(testBaseball.getFirst() == userBaseball.getFirst())
            this.setStrikeScore(this.getStrikeScore()+1);

        if(testBaseball.getSecond() == userBaseball.getSecond())
            this.setStrikeScore(this.getStrikeScore()+1);

        if(testBaseball.getThird() == userBaseball.getThird())
            this.setStrikeScore(this.getStrikeScore()+1);

        Assertions.assertThat(this.getStrikeScore()).isEqualTo(testScore.getStrikeScore());

    }

    @Test
    void countBall() {
        if(testBaseball.getFirst() == userBaseball.getSecond()
            ||testBaseball.getFirst()==userBaseball.getThird() )
        this.setBallScore(this.getBallScore()+1);
        if(testBaseball.getSecond() == userBaseball.getFirst()
                ||testBaseball.getSecond()==userBaseball.getThird() )
            this.setBallScore(this.getBallScore()+1);
        if(testBaseball.getThird() == userBaseball.getFirst()
                ||testBaseball.getThird()==userBaseball.getSecond() )
            this.setBallScore(this.getBallScore()+1);
        Assertions.assertThat(this.getBallScore()).isEqualTo(testScore.getBallScore());

    }


    public int getBallScore() {
        return BallScore;
    }

    public void setBallScore(int ballScore) {
        BallScore = ballScore;
    }

    public int getStrikeScore() {
        return StrikeScore;
    }

    public void setStrikeScore(int strikeScore) {
        StrikeScore = strikeScore;
    }
}