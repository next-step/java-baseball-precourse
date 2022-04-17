package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RandomUtilTest {
    @Test
    @DisplayName("랜덤 answer 생성 테스트")
    void randomUtilTest() {
        List<Integer> answer = RandomUtil.create();
        assertThat(answer.size()).isEqualTo(3);
    }


}
