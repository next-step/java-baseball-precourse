package baseball;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    @Test
    public void 정답_검증() {
        LinkedHashSet<Integer> validAnswer = new LinkedHashSet<>();
        validAnswer.add(1);
        validAnswer.add(2);
        validAnswer.add(3);

        assertThat(validAnswer)
                .isNotEmpty()
                .hasSize(3);
    }

    @Test
    public void 입력값_검증() {
        LinkedHashSet<Integer> validInput = new LinkedHashSet<>();
        validInput.add(1);
        validInput.add(2);
        validInput.add(3);

        assertThat(validInput)
                .isNotEmpty()
                .hasSize(3);
    }
}
