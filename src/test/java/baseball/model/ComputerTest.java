package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class ComputerTest {
    private static final Duration RANDOM_TEST_TIMEOUT = Duration.ofSeconds(5L);

    @Test
    @DisplayName("서로 다른 숫자 생성 확인(timeout)")
    void checkNumbersEachDifferent() {
        MockedStatic.Verification verification = () -> Randoms.pickNumberInRange(anyInt(), anyInt());

        assertThatThrownBy(() -> assertTimeoutPreemptively(RANDOM_TEST_TIMEOUT, () -> {
            try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
                mock.when(verification).thenReturn(1, 2, 2);
                Player computer = new Computer();
            }})
        ).isInstanceOf(AssertionError.class);
    }

    @Test
    @DisplayName("생성된_난수_길이_테스트")
    void checkMadeNumberLength() {
        // given, when
        Player computer = new Computer();
        // then
        assertThat(computer.getNumbers().size()).isEqualTo(3);
    }
}
