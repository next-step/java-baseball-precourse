package baseball.domain.model;

import baseball.domain.BallCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallCountTest {

    BallCount sut;

    @BeforeEach
    void beforeEach() {
        sut = new BallCount();
    }

    @Test
    void 스트라이크() {
        sut.addStrikeCount();

        assertThat(sut.getStrikeCount()).isEqualTo(1);
    }

    @Test
    void 볼() {
        sut.addBallCount();

        assertThat(sut.getBallCount()).isEqualTo(1);
    }

    @Test
    void 스트라이크_아웃() {
        sut.addStrikeCount();
        sut.addStrikeCount();
        sut.addStrikeCount();


        assertThat(sut.getIsStrikeOut()).isTrue();


    }

}
