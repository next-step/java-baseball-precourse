package baseball.player;

import baseball.ball.Ball;

import java.util.LinkedList;
import java.util.List;

public class User implements Player<String> {

    @Override
    public Ball createBall(String inputNumber) {
        List<Integer> ballNumbers = new LinkedList<>();
        String[] numbers = inputNumber.split("");
        for (String number : numbers) {
            ballNumbers.add(Integer.parseInt(number));
        }
        return new Ball(ballNumbers);
    }

}
