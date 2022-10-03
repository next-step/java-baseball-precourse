package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {
    
    private Game game;
    
    @BeforeEach
    private void setUp() {
        game = new Game();
    }
    
    @Test
    @DisplayName("게임 상태를 확인한다.")
    void new_game() {
        // when         
        GameStatus gameStatus = game.getStatus();

        // then 
        assertThat(gameStatus).isEqualTo(GameStatus.IN_PROGRESS);
    }

    @Test
    @DisplayName("힌트를 확인한다.")
    void getHint_hint() {
        // when
        Hint hint = game.getHint(BaseballNumbers.from("123"));
        
        // then
        assertThat(hint.getMessage()).isInstanceOf(String.class);
    } 

}