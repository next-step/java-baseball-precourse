package baseball.balls;

import baseball.balls.exceptions.BallsException;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private List<Ball> ballList;
    private List<Integer> ballNumberList = new ArrayList<>();

    public Balls(List<Ball> ballList) {
        valid(ballList);
        this.ballList = ballList;
    }

    private void valid(List<Ball> ballList) {
        for (int i = 0; i < ballList.size(); i++) {
            int ballNumber = ballList.get(i).getNumber();
            isDuplicated(ballNumber);
        }
    }

    private void isDuplicated(int number) {
        if (ballNumberList.contains(number)) {
            throw new BallsException("중복된 숫자는 입력할 수 없습니다.");
        }

        ballNumberList.add(number);
    }

    public List<Ball> getBallList() {
        return ballList;
    }

}
