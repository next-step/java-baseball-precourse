package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BallCollectionTest {
    private BallCollection collection;

    @BeforeEach
    void setup() {
        this.collection = new BallCollection();
        this.collection.add(new Ball(1, 0));
        this.collection.add(new Ball(2, 1));
        this.collection.add(new Ball(3, 2));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,0,STRIKE", "2,1,STRIKE", "3,2,STRIKE",
            "1,1,BALL", "2,2,BALL", "3,0,BALL",
            "4,0,NOTHING", "5,1,NOTHING", "6,2,NOTHING"}, delimiter = ',')
    void 하나의_공이_전달되었을_때_MATCH_결과를_리턴한다(int ballNumber, int ballLocation, MATCH_RESULT expected) {
        Assertions.assertThat(this.collection.match(new Ball(ballNumber, ballLocation))).isEqualTo(expected);
    }
}
