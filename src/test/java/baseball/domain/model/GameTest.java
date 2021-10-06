package baseball.domain.model;

import baseball.domain.BallCount;
import baseball.domain.Game;
import baseball.domain.RandomNumberPickerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;


public class GameTest {
    Game sut;
    RandomNumberPickerImpl mockRandomNumberPicker;

    @BeforeEach
    void beforeEach() {
        mockRandomNumberPicker = Mockito.mock(RandomNumberPickerImpl.class);

        Mockito.when(mockRandomNumberPicker.pick(Mockito.anyInt(), Mockito.anyInt())).thenReturn(1, 2, 3);


        sut = new Game(mockRandomNumberPicker);
    }

    @Test
    void 스트라이크아웃() {
        int[] answer = {1, 2, 3};

        BallCount ballCount = sut.check(answer);

        assertThat(ballCount.getIsStrikeOut()).isTrue();
    }

    @Test
    void 낫싱() {
        int[] answer = {4, 5, 6};

        BallCount ballCount = sut.check(answer);

        assertThat(ballCount.getIsStrikeOut()).isFalse();
        assertThat(ballCount.getBallCount()).isZero();
        assertThat(ballCount.getStrikeCount()).isZero();
    }

    @Test
    void 원스트라이크_원볼() {
        int[] answer = {1, 3, 4};

        BallCount ballCount = sut.check(answer);

        assertThat(ballCount.getIsStrikeOut()).isFalse();
        assertThat(ballCount.getBallCount()).isEqualTo(1);
        assertThat(ballCount.getStrikeCount()).isEqualTo(1);
    }
}
