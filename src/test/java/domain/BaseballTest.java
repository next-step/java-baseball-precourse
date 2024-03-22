package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BaseballTest {

    @Test
    @DisplayName("startGame 정상 실행")
    void startGame() {
        Baseball baseball = new Baseball();
        baseball.startGame();

        assertThat(baseball.getState()).isEqualTo(GameState.Running);
        assertThat(baseball.getNumbers()).isNotNull();
    }

    @Test
    @DisplayName("guessNumbers 오답 실행")
    void guessNumbersWrongAnswer() {
        Baseball baseball = new Baseball();
        baseball.startGame();

        Numbers answer = baseball.getNumbers();
        Numbers wrongAnswer = new Numbers(answer.getFirst(), answer.getSecond(), answer.getThird() + 1);
        baseball.guessNumbers(wrongAnswer);

        assertThat(baseball.getState()).isEqualTo(GameState.Running);
        assertThat(baseball.getNumbers()).isNotNull();
    }

    @Test
    @DisplayName("guessNumbers 정답 실행")
    void guessNumbersAnswer() {
        Baseball baseball = new Baseball();
        baseball.startGame();

        Numbers answer = baseball.getNumbers();
        baseball.guessNumbers(answer);

        assertThat(baseball.getState()).isEqualTo(GameState.End);
        assertThat(baseball.getNumbers()).isNotNull();
    }

    @Test
    @DisplayName("size=4 일 때 guessNumbers 정답 실행")
    void guessNumbersAnswerSize4() {
        Baseball baseball = new Baseball(4);
        baseball.startGame();

        Numbers answer = baseball.getNumbers();
        baseball.guessNumbers(answer);

        assertThat(baseball.getState()).isEqualTo(GameState.End);
        assertThat(baseball.getNumbers()).isNotNull();
    }

    @Test
    @DisplayName("오류 - Running 상태에서 startGame 실행")
    void startGameWhenRunningState() {
        Baseball baseball = new Baseball();
        baseball.startGame();

        assertThatThrownBy(baseball::startGame).
                isInstanceOf(BaseballStateException.class).
                hasMessageContaining("startGame은 Init, End 상태에서만 가능합니다 (현재 상태: Running)");
    }

    @Test
    @DisplayName("오류 - Init 상태에서 guessNumbers 실행")
    void guessNumbersWhenInitState() {
        Baseball baseball = new Baseball();

        assertThatThrownBy(() -> baseball.guessNumbers(null)).
                isInstanceOf(BaseballStateException.class).
                hasMessageContaining("guessNumbers는 Running 상태에서만 가능합니다 (현재 상태: Init)");
    }

    @Test
    @DisplayName("오류 - End 상태에서 guessNumbers 실행")
    void guessNumbersWhenEndState() {
        Baseball baseball = new Baseball();
        baseball.startGame();
        baseball.guessNumbers(baseball.getNumbers());

        assertThatThrownBy(() -> baseball.guessNumbers(null)).
                isInstanceOf(BaseballStateException.class).
                hasMessageContaining("guessNumbers는 Running 상태에서만 가능합니다 (현재 상태: End)");
    }

}