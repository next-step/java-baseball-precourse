package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballTest {

    private Baseball baseball;

    @BeforeEach
    void setUp() {
        baseball = new Baseball(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("Baseball 객체를 생성하여 객체를 비교한다")
    void create() {
        assertThat(baseball).isEqualTo(new Baseball(Arrays.asList(1, 2, 3)));
    }

    @Test
    @DisplayName("숫자는 3개까지만 가능하다")
    void 숫자는_3개까지만_가능() {
        assertThatThrownBy(() -> {
            Baseball baseball = new Baseball(Arrays.asList(1, 2, 3, 4));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리 까지만 가능");

    }

    @Test
    @DisplayName("숫자는 중복이 불가하다")
    void 숫자는_중복_불가() {
        assertThatThrownBy(() -> {
            Baseball baseball = new Baseball(Arrays.asList(1, 2, 1));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복 불가");
    }

    @Test
    void 스트라이크() {
        Baseball target = new Baseball(Arrays.asList(1, 2, 3));
        BaseballResult baseballResult = baseball.compare(target);
        assertThat(baseballResult).isEqualTo(new BaseballResult(3, 0));
    }

    @Test
    void 볼() {
        Baseball target = new Baseball(Arrays.asList(3, 2, 1));
        BaseballResult baseballResult = baseball.compare(target);
        assertThat(baseballResult).isEqualTo(new BaseballResult(1, 2));
    }

    @Test
    void 낫싱() {
        Baseball target = new Baseball(Arrays.asList(4, 5, 6));
        BaseballResult baseballResult = baseball.compare(target);
        assertThat(baseballResult).isEqualTo(new BaseballResult(0, 0));
    }
}