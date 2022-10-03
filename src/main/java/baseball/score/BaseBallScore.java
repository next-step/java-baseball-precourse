package baseball.score;

import baseball.common.ScoreType;

import java.util.ArrayList;
import java.util.List;

import static baseball.common.Constant.*;

public class BaseBallScore implements Score {
    int strike;
    int ball;
    List<String> scores = new ArrayList<>();

    public BaseBallScore() {
        this.strike = ZERO_VALUE;
        this.ball = ZERO_VALUE;
    }


    public void create(String ball1, String ball2) {
        createStrikeScore(ball1.toCharArray(), ball2.toCharArray());
        createBallScore(ball1, ball2);

    }

    private void createBallScore(String ball1, String ball2) {
       for(char ball :ball1.toCharArray()){
           String str = String.valueOf(ball);
           if(ball2.contains(str)) addBall();
       }
    }

    void createStrikeScore(char[] arr1, char[] arr2 ) {
        for(int i =0; i< arr1.length; i++) {
            if(arr1[i]== arr2[i]) addStrike();
        }
    }

    public void addStrike() {
        strike += ONE_VALUE;
    }

    public void addBall() {
        ball += ONE_VALUE;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isNothing() {
        return strike == ZERO_VALUE && ball == ZERO_VALUE;
    }

    @Override
    public List<String> getScores() {
        if (isNothing()) {
            setNothing();
            return scores;
        }
        setBall();
        setStrikeScore();
        return scores;
    }

    void setBall() {
        if (getBall() != 0) scores.add(ScoreType.BALL.getDescription(this.ball));
    }

    void setStrikeScore() {
        if (getStrike() != 0) scores.add(ScoreType.STRIKE.getDescription(this.strike));
    }

    void setNothing(){
        if (isNothing()) scores.add(ScoreType.NOTHING.getDescription(ZERO_VALUE));
    }

    @Override
    public String toString() {
        List<String> scores = getScores();
        String description = EMPTY;
        for (String score : scores) {
            description += score;
            if (scores.indexOf(score) < scores.size() - 1)
                description += BLANK;
        }
        return description;
    }
}
