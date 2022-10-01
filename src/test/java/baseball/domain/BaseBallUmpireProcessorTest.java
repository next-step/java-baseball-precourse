package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BaseBallUmpireProcessorTest {

    @ParameterizedTest
    @MethodSource("provider")
    public void 심판의_판정값이_정상적으로_계산_및_반환되어야_한다(List<Integer> computerInput, List<Integer> userInput, int strikeCount,
                                             int ballCount) {
        // given
        BaseBallUmpireProcessor processor = new BaseBallUmpireProcessor();
        BaseBallNumbers computerNumbers = new BaseBallNumbers(computerInput);
        BaseBallNumbers userNumbers = new BaseBallNumbers(userInput);

        // when
        BaseBallUmpire umpire = processor.process(computerNumbers, userNumbers);

        // then
        assertThat(umpire.getStrike()).isEqualTo(strikeCount);
        assertThat(umpire.getBall()).isEqualTo(ballCount);
    }

    static List<Arguments> provider() {
        List<Arguments> arguments = new ArrayList<>();
        arguments.add(arguments(Arrays.asList(3, 6, 9), Arrays.asList(2, 4, 8), 0, 0)); // 낫싱
        arguments.add(arguments(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3), 3, 0)); // 3스트라이크
        arguments.add(arguments(Arrays.asList(2, 3, 6), Arrays.asList(6, 2, 3), 0, 3)); // 3볼
        arguments.add(arguments(Arrays.asList(9, 1, 3), Arrays.asList(9, 3, 1), 1, 2)); // 1스트라이크 2볼
        arguments.add(arguments(Arrays.asList(5, 8, 2), Arrays.asList(5, 8, 1), 2, 0)); // 2스트라이크
        return arguments;
    }
}