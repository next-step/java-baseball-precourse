package baseball;

import java.util.ArrayList;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomInputGeneratorTest {
    @Test
    void 중복되지_않은_3개의_정수를_가진_리스트를_생성한다() {
        ArrayList<Integer> randoms = new RandomInputGenerator().genRandomInts();

        Assertions.assertThat(randoms.size()).isEqualTo(GlobalVariables.MAX_BALL_CNT);

        for (int i = 0; i < GlobalVariables.MAX_BALL_CNT; i++) {
            Assertions.assertThat(randoms).containsOnlyOnce(randoms.get(i));
        }
    }
}
