package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerBaseballNumberTest {

    private ComputerBaseballNumber computerNumber = new ComputerBaseballNumber();

    @Test
    @DisplayName("서로 다른 세 개의 난수를 생성한다")
    void create_random_number() {
        List<Integer> randomNumbers = computerNumber.createNumbers();

        assertThat(randomNumbers.size()).isEqualTo(3);
    }
}
