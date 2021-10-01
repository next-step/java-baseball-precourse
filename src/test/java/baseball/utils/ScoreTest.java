package baseball.utils;

import baseball.commons.Constant;
import baseball.exception.IncorrectInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    @Test
    public void 볼_초과_추가_입력() throws Exception {
        Score score = new Score(0, Constant.GAME_PITCHING_COUNT);
        assertThrows(IncorrectInputException.class, () -> score.addBall());
    }

    @Test
    public void 스트라이크_초과_추가_테스트() throws Exception {
        Score score = new Score(Constant.GAME_PITCHING_COUNT, 0);
        assertThrows(IncorrectInputException.class, () -> score.addStrike());
    }

    @Test
    @DisplayName("낫싱")
    public void 점수계산1() throws Exception {
        //given
        Score score = new Score(0, 0);

        //when
        score.scoreCalculation("123", "456");

        //then
        assertThat(score.getStrike()).isEqualTo(0);
        assertThat(score.getBall()).isEqualTo(0);
        assertThat(score.isNothing()).isTrue();
    }

    @Test
    @DisplayName("1스트라이크 2볼")
    public void 점수계산2() throws Exception {
        //given
        Score score = new Score(0, 0);

        //when
        score.scoreCalculation("123", "132");

        //then
        assertThat(score.getStrike()).isEqualTo(1);
        assertThat(score.getBall()).isEqualTo(2);
    }

    @Test
    @DisplayName("3스트라이크")
    public void 점수계산3() throws Exception {
        //given
        Score score = new Score(0, 0);

        //when
        score.scoreCalculation("132", "132");

        //then
        assertThat(score.isThreeStrike()).isTrue();
    }

}