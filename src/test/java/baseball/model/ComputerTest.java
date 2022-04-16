package baseball.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class ComputerTest {

    @Test
    void generateRandomNumber() {
        Computer computer = new Computer();
        Set<Integer> number = computer.getNumber();
        assertThat(number).hasSize(3).doesNotHaveDuplicates().doesNotContain(0);
    }

    @ParameterizedTest
    @MethodSource(value = {"generateCountStrikeData"})
    void countStrikeTest(List<Integer> computerNumber, List<Integer> playerNumber, int expected) {
        Computer computer = new Computer(new LinkedHashSet<>(computerNumber));
        assertThat(computer.countStrike(playerNumber)).isEqualTo(expected);
    }

    private static Stream<Arguments> generateCountStrikeData() {
        return Stream.of(
            Arguments.of(Arrays.asList(7, 1, 3), Arrays.asList(1, 2, 3), 1),
            Arguments.of(Arrays.asList(7, 1, 3), Arrays.asList(1, 4, 5), 0),
            Arguments.of(Arrays.asList(7, 1, 3), Arrays.asList(6, 7, 1), 0),
            Arguments.of(Arrays.asList(7, 1, 3), Arrays.asList(2, 1, 6), 1),
            Arguments.of(Arrays.asList(7, 1, 3), Arrays.asList(7, 1, 6), 2),
            Arguments.of(Arrays.asList(7, 1, 3), Arrays.asList(7, 1, 3), 3)
        );
    }

    @ParameterizedTest
    @MethodSource(value = {"generateCountBallData"})
    void countBallTest(List<Integer> computerNumber, List<Integer> playerNumber, int expected) {
        Computer computer = new Computer(new LinkedHashSet<>(computerNumber));
        assertThat(computer.countBall(computer.countStrike(playerNumber), playerNumber)).isEqualTo(expected);
    }

    private static Stream<Arguments> generateCountBallData() {
        return Stream.of(
            Arguments.of(Arrays.asList(7, 1, 3), Arrays.asList(1, 2, 3), 1),
            Arguments.of(Arrays.asList(7, 1, 3), Arrays.asList(1, 4, 5), 1),
            Arguments.of(Arrays.asList(7, 1, 3), Arrays.asList(6, 7, 1), 2),
            Arguments.of(Arrays.asList(7, 1, 3), Arrays.asList(2, 1, 6), 0),
            Arguments.of(Arrays.asList(7, 1, 3), Arrays.asList(7, 1, 6), 0),
            Arguments.of(Arrays.asList(7, 1, 3), Arrays.asList(7, 1, 3), 0)
        );
    }
}