package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {
    private Game game = new Game(Player.createPlayer());


    @Test
    @DisplayName(value = "입력 숫자 유효 테스트")
    public void isValidateInputValueTest(){
        assertThat(game.isValidateInputValue("123"));
        assertThrows(IllegalArgumentException.class, () -> game.isValidateInputValue("1234"));
        assertThrows(IllegalArgumentException.class, () -> game.isValidateInputValue("a34"));
        assertThrows(IllegalArgumentException.class, () -> game.isValidateInputValue("23"));
        assertThrows(IllegalArgumentException.class, () -> game.isValidateInputValue("012"));
        assertThrows(IllegalArgumentException.class, () -> game.isValidateInputValue("112"));
    }


    @Test
    @DisplayName(value = "스트라이크, 볼, 낫싱 비교 후 카운트 테스트")
    public void countUpEachStatusStrikeTest(){
        List<String> computerNumberList = Arrays.asList("1","2","3");
        game.countUpEachStatus("123", computerNumberList);
        assertThat(game.getStrike()).isEqualTo(3);
        assertThat(game.getBall()).isEqualTo(0);
        assertThat(game.getNothing()).isEqualTo(0);
    }


    @Test
    @DisplayName(value = "볼 카운트 테스트")
    public void countUpEachStatusBallTest(){
        List<String> computerNumberList = Arrays.asList("1","2","3");
        game.countUpEachStatus("132", computerNumberList);
        assertThat(game.getStrike()).isEqualTo(1);
        assertThat(game.getBall()).isEqualTo(2);
        assertThat(game.getNothing()).isEqualTo(0);
    }

}
