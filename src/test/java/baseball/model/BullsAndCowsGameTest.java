package baseball.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BullsAndCowsGameTest {

    @ParameterizedTest
    @MethodSource("generateData")
    void challenge(List<Integer> answer, List<Integer> trial, int strikeCnt, int ballCnt) {
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
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), 0, 0),
                Arguments.of(Arrays.asList(6, 3, 7), Arrays.asList(4, 5, 1), 0, 0),
                // zero strike & one ball
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(9, 1, 4), 0, 1),
                Arguments.of(Arrays.asList(6, 3, 7), Arrays.asList(2, 6, 1), 0, 1),
                // one strike & zero ball
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 5, 6), 1, 0),
                Arguments.of(Arrays.asList(6, 3, 7), Arrays.asList(4, 5, 7), 1, 0),
                // zero ball & three strike
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3), 3, 0),
                Arguments.of(Arrays.asList(6, 3, 7), Arrays.asList(6, 3, 7), 3, 0)
        );
    }
}
