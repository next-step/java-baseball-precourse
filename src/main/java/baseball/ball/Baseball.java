package baseball.ball;

import java.util.*;

public class Baseball {
    final Integer BALL_SIZE = 3;
    String ball;

    protected Baseball() {
    }

    public void createBall() {}

    protected Baseball(String ball) {
        this.ball = ball;
    }

    public void setBall(String ball) {
        this.ball = ball;
    }

    public String getBall() {
        return ball;
    }

    public void checkValidation() {
        checkBallSize();
        checkDistinct();
    }

    private void checkBallSize(){
        int ballLength = ball.length();
        if (ball == null || ballLength != BALL_SIZE) throw new IllegalArgumentException();
    }

    private void checkDistinct() {
        HashSet<Character> distinct = new HashSet<>();
        for(char a : ball.toCharArray()){
            distinct.add(a);
        }
        if(distinct.size() != BALL_SIZE){
            throw new IllegalArgumentException();
        }
    }
}
