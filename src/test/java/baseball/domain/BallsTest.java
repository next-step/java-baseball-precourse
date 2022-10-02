package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BallsTest {

    private Balls computer;

    @BeforeEach
    void init() {
        computer = Balls.of(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("3자리 수 서로 다른 수 검증 - 성공")
    void 세자리_수_서로_다른_수_검증_성공() {
        assertDoesNotThrow(() -> new Balls(Arrays.asList(new Ball(0, 1), new Ball(1, 2), new Ball(2, 3))));
    }

    @Test
    @DisplayName("3자리 수 서로 다른 수 검증 - 실패")
    void 세자리_수_서로_다른_수_검증_실패() {
        assertThrows(IllegalArgumentException.class, () -> new Balls(Arrays.asList(new Ball(0, 1), new Ball(1, 1), new Ball(2, 3))));
    }

    @Test
    @DisplayName("세자리 수 검증 - 성공")
    void 세자리_수_검증_성공() {
        assertDoesNotThrow(() -> new Balls(Arrays.asList(new Ball(0, 1), new Ball(1, 2), new Ball(2, 3))));
    }

    @Test
    @DisplayName("세자리 수 검증 - 실패 1")
    void 세자리_수_검증_실패_1() {
        assertThrows(IllegalArgumentException.class, () -> new Balls(Arrays.asList(new Ball(1, 1), new Ball(2, 3))));
    }

    @Test
    @DisplayName("세자리 수 검증 - 실패 2")
    void 세자리_수_검증_실패_2() {
        assertThrows(IllegalArgumentException.class, () -> new Balls(Arrays.asList(new Ball(0, 1), new Ball(1, 1), new Ball(2, 3), new Ball(3, 4))));
    }

    @Test
    @DisplayName("세자리 수 리스트 입력 - 성공")
    void 세자리_수_리스트_입력_성공() {
        assertDoesNotThrow(() -> Balls.of(Arrays.asList(1, 2, 3)));
    }

    @Test
    @DisplayName("세자리 수 리스트 입력 - 실패(중복 숫자)")
    void 세자리_수_리스트_입력_실패_중복_숫자() {
        assertThrows(IllegalArgumentException.class, () -> Balls.of(Arrays.asList(1, 3, 3)));
    }

    @Test
    @DisplayName("두자리 수 리스트 입력 - 실패")
    void 두자리_수_리스트_입력_실패() {
        assertThrows(IllegalArgumentException.class, () -> Balls.of(Arrays.asList(1, 3)));
    }

    @ParameterizedTest
    @DisplayName("스트라이크/볼 판정 로직")
    @MethodSource("provideBallNumbers")
    void play(List<Integer> input, List<Integer> expected) {
        PlayResult playResult = computer.inning(Balls.of(input));
        assertThat(playResult.getStrike()).isEqualTo(expected.get(0));
        assertThat(playResult.getBall()).isEqualTo(expected.get(1));
    }

    private static Stream<Arguments> provideBallNumbers() {
        // computer : 1 2 3
        return Stream.of(
                // 3 스트라이크
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(3, 0)),
                // 2 스트라이크
                Arguments.of(Arrays.asList(4, 2, 3), Arrays.asList(2, 0)),
                // 1 스트라이크
                Arguments.of(Arrays.asList(4, 5, 3), Arrays.asList(1, 0)),
                // 3 볼
                Arguments.of(Arrays.asList(2, 3, 1), Arrays.asList(0, 3)),
                // 2 볼
                Arguments.of(Arrays.asList(4, 3, 1), Arrays.asList(0, 2)),
                // 1 볼
                Arguments.of(Arrays.asList(4, 3, 5), Arrays.asList(0, 1)),
                // 1 스트라이크 2 볼
                Arguments.of(Arrays.asList(1, 3, 2), Arrays.asList(1, 2)),
                // 1 스트라이크 1 볼
                Arguments.of(Arrays.asList(1, 3, 4), Arrays.asList(1, 1)),
                // 낫싱
                Arguments.of(Arrays.asList(4, 5, 6), Arrays.asList(0, 0))
        );
    }
}
