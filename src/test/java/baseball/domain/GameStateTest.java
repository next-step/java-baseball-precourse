package baseball.domain;

import baseball.exception.BaseballGameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameStateTest {

    @DisplayName("state 에 해당하는 게임 상태를 반환한다")
    @Test
    void whenInputState_thenReturnGameState() {
        // given
        // when
        GameState progress = GameState.getGameState("1");
        GameState end = GameState.getGameState("2");

        // then
        assertThat(progress).isEqualTo(GameState.PROGRESS);
        assertThat(end).isEqualTo(GameState.END);
    }

    @DisplayName("state 에 해당하는 게임 상태가 없다면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"0", "3", "10", "-1", "dd", "테스트", " "})
    void whenInputState_thenReturnGameState(String state) {
        // given
        // when
        // then
        assertThatThrownBy(() -> GameState.getGameState(state))
                .isInstanceOf(BaseballGameException.class);
    }
}