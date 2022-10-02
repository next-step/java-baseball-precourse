package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    @Test
    void 숫자_생성시_1에서9사이로_이루어진_중복없는_임의의값_3개가_나온다() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        List<Integer> generatedNumbers = numberGenerator.generate();
        assertThat(generatedNumbers).hasSize(3)
                .containsAnyOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .doesNotHaveDuplicates();
    }
}