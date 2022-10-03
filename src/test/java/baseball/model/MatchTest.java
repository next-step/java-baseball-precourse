package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatchTest {

    @Test
    void MatchInitTest() {
        Player inputPlayer = new Player();
        Player guessPlayer = new Player();
        Match match = new Match(inputPlayer, guessPlayer);
        guessPlayer.setNumbers(Arrays.asList(1, 2, 3));
        match.setInputPlayerNumber(Arrays.asList(2, 5, 1));
        assertThat(match.getPlayerBallCount()).isEqualTo(2);
        assertThat(match.getPlayerStrikeCount()).isEqualTo(0);

        match.setInputPlayerNumber(Arrays.asList(1, 2, 3));
        assertThat(match.getPlayerStrikeCount()).isEqualTo(3);

        Computer guessComputer = new Computer();
        Match match2 = new Match(inputPlayer, guessComputer);

        List<Integer> testInput2 = new ArrayList<>(guessComputer.getNumbers());
        match2.setInputPlayerNumber(testInput2);
        assertThat(match2.getPlayerStrikeCount()).isEqualTo(3);
        assertThat(guessComputer.getNumbers()).isEqualTo(testInput2);

        testInput2.set(2, testInput2.get(2)+1);
        assertThat(match2.getPlayerStrikeCount()).isEqualTo(2);
        assertThat(guessComputer.getNumbers()).isNotEqualTo(testInput2);
    }
}
