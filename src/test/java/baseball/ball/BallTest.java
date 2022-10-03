package baseball.ball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

public class BallTest {

    private List<Integer> ballNumbers;

    @BeforeEach
    public void initBallNumbers() {
        ballNumbers = new LinkedList<>();
        ballNumbers.addAll(Arrays.asList(1, 2, 3));
    }

    @Test
    void create_ball_instance() {
        List<Integer> ballNumber = new LinkedList<>();
        assertThatCode(() -> new Ball(ballNumber))
                .doesNotThrowAnyException();
    }
}
