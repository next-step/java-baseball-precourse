package baseball.util;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ComputerBallList 생성 테스트")
class BallListGeneratorTest {

    private List<Integer> generateBallList;

    @BeforeEach
    public void setUp() {
        generateBallList = BallListGenerator.generateComputerBallList();
    }

    @Test
    @DisplayName("0이 포함되지 않는 3자리 수가 생성되는지 확인")
    void checkGenerateBallList() {
        // then
        assertAll(
                () -> assertThat(generateBallList).isNotEmpty(),
                () -> assertThat(!generateBallList.contains(0)).isTrue(),
                () -> assertThat(generateBallList.size()).isEqualTo(3)
        );
    }

    @Test
    @DisplayName("서로 다른 수로 이루어진 3자리 수가 생성되는지 확인")
    void checkDuplicateBall() {
        // given // when
        Set<Integer> removeDuplicate = new HashSet<>(generateBallList);

        // then
        assertAll(
                () -> assertThat(generateBallList).isNotEmpty(),
                () -> assertThat(!generateBallList.contains(0)).isTrue(),
                () -> assertThat(removeDuplicate.size()).isEqualTo(3)
        );
    }
}
