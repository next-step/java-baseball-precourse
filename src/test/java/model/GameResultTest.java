package model;

import org.junit.jupiter.api.Test;

import static model.BaseballNumber.VALID_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

    @Test
    void isNothing() {
        // given
        GameResult result = new GameResult(0, 0);

        // when
        boolean nothing = result.isNothing();

        // then
        assertThat(nothing).isTrue();
    }

    @Test
    void isOver() {
        // given
        GameResult result = new GameResult(VALID_LENGTH, 0);

        // when
        boolean over = result.isOver();

        // then
        assertThat(over).isTrue();
    }
}