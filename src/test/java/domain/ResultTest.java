package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    private Result result = new Result();

    @BeforeEach
    void setUp() {
        result.setStrike(2);
        result.setBall(1);
    }

    @Test
    void getStrikeEqualsResultStrike(){
        assertThat(result.getStrike()).isEqualTo(2);
    }

    @Test
    void getBallEqualsResultBall(){
        assertThat(result.getBall()).isEqualTo(1);
    }
}
