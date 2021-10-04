package baseball.model;

import baseball.model.enums.AnswerSize;
import baseball.model.utils.RandomBallNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

@DisplayName("RandomBallNumberGenerator: 중복되지 않는 수로 만들어진 List 를 리턴하는 클래스")
public class RandomBallNumberGeneratorTest {

    @DisplayName("파라미터로 받은 사이즈 만큼의 List 를 생성해야 함")
    @ParameterizedTest
    @EnumSource(AnswerSize.class)
    void testSize(AnswerSize answerSize) {
        List<Integer> list = RandomBallNumberGenerator.generate(answerSize);
        assertThat(list.size()).isEqualTo(answerSize.size());
    }

    @DisplayName("생성된 List 는 중복이 없어야함")
    @ParameterizedTest
    @EnumSource(AnswerSize.class)
    void testDuplicate(AnswerSize answerSize) {
        List<Integer> list = RandomBallNumberGenerator.generate(answerSize);
        Set<Integer> set = new HashSet<>(list);
        assertThat(set.size()).isEqualTo(list.size());
    }
}
