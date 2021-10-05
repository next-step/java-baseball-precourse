package baseball;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallTest {

    @Test
    void ballMaxNumberTestFail() {
        assertThatThrownBy(
                () -> Ball.of(10, 0)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void ballMaxNumberTestPass() {
        assertThat(Ball.of(9, 0).matchBallNumber(9)).isTrue();
    }

    @Test
    void ballMinNumberTestFail() {
        assertThatThrownBy(
                () -> Ball.of(0, 0)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void ballMixNumberTestPass() {
        assertThat(Ball.of(1, 0).matchBallNumber(1)).isTrue();
    }


    @Test
    void strikeTest() {
        Ball ball = Ball.of(1, 0);
        assertThat(ball.compareBall(Ball.of(1, 0))).isEqualTo(Status.STRIKE);
    }

    @Test
    void ballTest() {
        Ball ball = Ball.of(1, 0);
        assertThat(ball.compareBall(Ball.of(1, 1))).isEqualTo(Status.BALL);
    }

    @Test
    void NothingTest() {
        Ball ball = Ball.of(1, 0);
        assertThat(ball.compareBall(Ball.of(2, 2))).isEqualTo(Status.NOTHING);
    }

    @Test
    void test() {
        LinkedHashSet<Integer> luckyNumbers = new LinkedHashSet<>();
        while (luckyNumbers.size() < 3) {
            luckyNumbers.add(7);
            luckyNumbers.add(1);
            luckyNumbers.add(3);
        }
        Iterator<Integer> it = luckyNumbers.iterator();

        int i = 0;

        while (it.hasNext()) { // hasNext() : 데이터가 있으면 true 없으면 false
            System.out.println(it.next()); // next() : 다음 데이터 리턴
        }


    }
}
