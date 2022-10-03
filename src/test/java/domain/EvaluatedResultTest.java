package domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EvaluatedResultTest {

    private GeneratedNumbers generatedNumbers;
    private String input = "";
    @BeforeEach
    void setUp() {
        generatedNumbers = new GeneratedNumbers();
        for(int i = 0; i < 3; i++) {
            input = input + Randoms.pickNumberInRange(1, 9);
        }
    }

    @Test
    void evaluationResultIsNotNull() {
        EvaluatedResult evaluatedResult = new EvaluatedResult(generatedNumbers, new InputNumbers(input));
        assertThat(evaluatedResult).isNotNull();
    }
}
