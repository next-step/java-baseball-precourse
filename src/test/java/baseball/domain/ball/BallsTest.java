package baseball.domain.ball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.domain.result.Result;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BallsTest {

    @Test
    void 인스턴스가_생성된다() {
        assertThatCode(() -> new Balls(createBallList()))
            .doesNotThrowAnyException();
    }

    @Test
    void 볼이_3개가_아니라면_예외가_발생한다() {
        assertThatThrownBy(() -> new Balls(new ArrayList<>()))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("볼은 3개여야 합니다.");
    }

    @Test
    void 볼이_널일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Balls(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("볼은 3개여야 합니다.");
    }

    @Test
    void 정적_팩토리_메서드_테스트() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        assertThatCode(() -> Balls.from(numbers))
            .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:2", "2:3"}, delimiter = ':')
    void 볼의_인덱스를_확인한다(int expectedIndex, int ballNumber) {
        Balls balls = new Balls(createBallList());

        int indexOf = balls.indexOf(new Ball(ballNumber));
        assertThat(indexOf).isEqualTo(expectedIndex);
    }

    @Test
    void 볼들을_비교한다() {
        Balls balls1 = new Balls(createBallList());
        Balls balls2 = new Balls(createBallList());

        Result result = balls1.compareTo(balls2);
        assertThat(result).isNotNull();
    }

    private List<Ball> createBallList() {
        List<Ball> ballList = new ArrayList<>();
        ballList.add(new Ball(1));
        ballList.add(new Ball(2));
        ballList.add(new Ball(3));

        return ballList;
    }
}