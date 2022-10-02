package baseball.domain.player;

import baseball.domain.ball.Balls;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private final Balls balls;

    private Player(Balls balls) {
        this.balls = balls;
    }

    public static Player from(String ballNumbers) {
        List<Integer> list = new ArrayList<>();
        for (String number : ballNumbers.split("")) {
            list.add(Integer.parseInt(number));
        }
        return new Player(Balls.from(list));
    }

    public Balls getBalls() {
        return balls;
    }
}
