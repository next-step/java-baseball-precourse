package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseBallNumberGeneratorTest {

    @Test
    public void 서로_다른_3자리_숫자_생성() {

        // given
        BaseBallNumbersGenerator baseBallNumberGenerator = new BaseBallNumbersGenerator();

        // when
        BaseBallNumbers baseBallNumbers = baseBallNumberGenerator.createRandomBaseBallNumbers();

        // then
        Set<Integer> nonDuplicates = new HashSet<>(baseBallNumbers.getThreeDigits());
        assertThat(new HashSet<>(nonDuplicates)).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "abc", "1", "12", "012", "111", "112", "1233", "1234", "!@$#@#", ""})
    public void 유저_입력이_중복없는_1에서_9사이의_숫자로_이루어지지않거나_문자열이면_에러(String userInput) {
        // given
        BaseBallNumbersGenerator baseBallNumbersGenerator = new BaseBallNumbersGenerator();

        // when && then
        assertThatIllegalArgumentException().isThrownBy(
                () -> baseBallNumbersGenerator.createBaseBallNumbers(userInput));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789", "159", "253"})
    public void 유저_입력이_중복없는_3자리_숫자이면_성공(String userInput) {
        // given
        BaseBallNumbersGenerator baseBallNumbersGenerator = new BaseBallNumbersGenerator();

        // when
        BaseBallNumbers userNumbers = baseBallNumbersGenerator.createBaseBallNumbers(userInput);

        // then
        Set<Integer> nonDuplicates = new HashSet<>(userNumbers.getThreeDigits());
        assertThat(new HashSet<>(nonDuplicates)).hasSize(3);
    }

}