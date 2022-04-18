package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerRandomNumberGeneratorTest {
    AnswerRandomNumberGenerator answerRandomNumberGenerator;

    @BeforeEach
    public void setUp() {
        answerRandomNumberGenerator = new AnswerRandomNumberGenerator();
    }

    @Test
    @DisplayName("정답 난수 3자리의 사이즈를 체크하는 테스트")
    public void answerRandomNumberGeneratorSizeTest() {
        // Given
        int answerRandomNumberSIze;

        // When
        answerRandomNumberSIze = answerRandomNumberGenerator.generateAnswerRandomNumbers().length();

        // Then
        assertThat(answerRandomNumberSIze)
                .isEqualTo(3)
        ;
    }
}