package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameTest {

    BaseballGame baseballGame;

    @BeforeEach
    void setUp() {
        baseballGame = new BaseballGame();
    }

    @Test
    @DisplayName("정답 번호 생성 테스트")
    void generateAnswerNum() {
        List<Integer> testList = baseballGame.getAnswerNumList();

        assertThat(testList)
                .size()
                .isEqualTo(3);

        for (int i = 0; i < 3; i++) {
            assertThat(testList.get(i))
                    .isBetween(1, 9);
        }

        assertThat(testList.get(0))
                .isNotEqualTo(testList.get(1))
                .isNotEqualTo(testList.get(2));

        assertThat(testList.get(1))
                .isNotEqualTo(testList.get(2));
    }
}