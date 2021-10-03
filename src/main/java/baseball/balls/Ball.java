package baseball.balls;

import baseball.balls.exceptions.BallException;

public class Ball {
    private final int MIN_POSITION = 1;
    private final int MAX_POSITION = 3;

    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;

    private final String BALL_POSITION_RANGE_ERROR = "위치의 범위는 1이상 3이하이여야 합니다.";
    private final String BALL_NUMBER_RANGE_ERROR = "숫자의 범위는 1이상 9이하이여야 합니다.";

    private int position;
    private int number;

    public Ball(int position,int number){
        validation(position,number);
        this.position = position;
        this.number = number;
    }

    private void validation(int position,int number) {
        if(position < MIN_POSITION || position > MAX_POSITION){
            throw new BallException(BALL_POSITION_RANGE_ERROR);
        }

        if(number < MIN_NUMBER || number > MAX_NUMBER){
            throw new BallException(BALL_NUMBER_RANGE_ERROR);
        }
    }

    public int getPosition() {
        return position;
    }

    public int getNumber() {
        return number;
    }
}
