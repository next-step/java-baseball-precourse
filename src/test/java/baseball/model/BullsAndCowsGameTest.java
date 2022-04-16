package baseball.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BullsAndCowsGameTest {

    @ParameterizedTest
    @MethodSource("generateData")
    void challenge(String answer, String trial, int strikeCnt, int ballCnt) {
        // given
        BullsAndCowsGame game = new BullsAndCowsGame(new Answer(answer));

        // when
        Result result = game.challenge(new Trial(trial));

        // then
        assertEquals(strikeCnt, result.getStrike());
        assertEquals(ballCnt, result.getBall());
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                // zero ball & zero strike
                Arguments.of("123", "456", 0, 0),
                Arguments.of("637", "451", 0, 0),
                // zero strike & one ball
                Arguments.of("123", "914", 0, 1),
                Arguments.of("637", "261", 0, 1),
                // one strike & zero ball
                Arguments.of("123", "156", 1, 0),
                Arguments.of("637", "457", 1, 0),
                // zero ball & three strike
                Arguments.of("123", "123", 3, 0),
                Arguments.of("637", "637", 3, 0)
        );
    }

    @Test
    void end() {
        // given
        BullsAndCowsGame game = new BullsAndCowsGame(new Answer("123"));

        // when
        game.challenge(new Trial("456"));

        // then
        assertFalse(game.isEnd());

        // when
        game.challenge(new Trial("123"));

        // then
        assertTrue(game.isEnd());
    }
}
