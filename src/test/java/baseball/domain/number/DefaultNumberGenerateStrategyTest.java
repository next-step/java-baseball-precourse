package baseball.domain.number;

import java.util.HashSet;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DefaultNumberGenerateStrategyTest {

    @Test
    @DisplayName("3자리 수 생성 (= 3개의 BaseballNumber 생성)")
    void generateTest1() {
        // given
        DefaultNumberGenerateStrategy strategy = new DefaultNumberGenerateStrategy();

        // when
        List<BaseballNumber> baseballNumbers = strategy.generate();

        // then
        Assertions.assertThat(baseballNumbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("생성된 수의 각 자리값이 중복되지 않는다. (= 서로 다른 BaseballNumber)")
    void generateTest2() {
        // given
        DefaultNumberGenerateStrategy strategy = new DefaultNumberGenerateStrategy();

        // when
        List<BaseballNumber> baseballNumbers = strategy.generate();

        // then
        Assertions.assertThat(baseballNumbers.size()).isEqualTo(new HashSet<>(baseballNumbers).size());
    }
}