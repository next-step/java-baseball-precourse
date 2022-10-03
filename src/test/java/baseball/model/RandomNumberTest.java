package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.constant.GameEnvironment;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class RandomNumberTest {

    private List<List<Integer>> randomNumbersList;
    private Set<Integer> randomSet;

    @BeforeAll
    void setUp() {
        randomNumbersList = new LinkedList<>();
        randomNumbersList.add(Arrays.asList(1, 1, 2));
        randomNumbersList.add(Arrays.asList(1, 2, 1));
        randomNumbersList.add(Arrays.asList(2, 1, 1));
        randomNumbersList.add(Arrays.asList(2, 2, 2));
    }

    @Test
    @DisplayName("게임 제약조건에 맞는 사이즈의 값을 가진 난수 리스트 생성")
    void createRandomList() {
        // given
        RandomNumber randomNumber = new RandomNumber();

        // when
        List<Integer> randomList = randomNumber.getRandomList();

        // then
        assertThat(randomList.size()).isEqualTo(GameEnvironment.NUMBER_SIZE);

    }

    @Test
    @DisplayName("생성된 난수 리스트에 중복이 없는지 검증")
    void isNotContainsDuplicatedNumber() {
        for (List<Integer> randomList : randomNumbersList) {
            // given
            randomSet = new LinkedHashSet<>();

            // when
            applyDuplicatedValue(randomList);

            // then
            assertThat(randomSet.size()).isNotEqualTo(GameEnvironment.NUMBER_SIZE);
        }
    }

    private void applyDuplicatedValue(List<Integer> duplicatedValueList) {
        for (Integer integer : duplicatedValueList) {
            randomSet.add(integer);
        }
    }
}