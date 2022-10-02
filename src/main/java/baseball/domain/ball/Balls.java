package baseball.domain.ball;

import static java.util.Collections.unmodifiableList;

import baseball.domain.result.Result;
import baseball.domain.result.Score;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Balls {

    private final List<Ball> content;

    public Balls(List<Ball> content) {
        validateSize(content);
        this.content = unmodifiableList(content);
    }

    public static Balls from(Collection<Integer> ballNumbers) {
        List<Ball> balls = new ArrayList<>();
        for (Integer number : ballNumbers) {
            balls.add(new Ball(number));
        }
        return new Balls(balls);
    }

    private static void validateSize(List<Ball> content) {
        if (content == null || content.size() != 3) {
            throw new IllegalArgumentException("볼은 3개여야 합니다.");
        }
    }

    public int indexOf(Ball ball) {
        return content.indexOf(ball);
    }

    public Result compareTo(Balls other) {
        List<Score> scores = new ArrayList<>();
        for (int i = 0; i < content.size(); i++) {
            Ball ball = content.get(i);
            int indexOf = other.indexOf(ball);
            scores.add(Score.of(i, indexOf));
        }
        return Result.from(scores);
    }
}