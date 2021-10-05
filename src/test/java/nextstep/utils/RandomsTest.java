package nextstep.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomsTest {

    @RepeatedTest(value = 5, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    @DisplayName(value = "1과 9사이의 랜덤한 숫자가 나오는지 체크!")
    public void 랜덤한수_1과9사이인지() {
        assertThat(Randoms.pickNumberInRange(1, 9))
                .isNotNull()
                .isGreaterThanOrEqualTo(1)
                .isLessThanOrEqualTo(9);
    }

    @RepeatedTest(value = 100, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    @DisplayName(value = "중복된 랜덤한 숫자가 나오는지 체크!")
    public void 중복된3자리의수() {
        List<Integer> balls = new ArrayList<>();
        while(balls.size() < 3) {
            balls.add(Randoms.pickNumberInRange(1, 9));
        }
        Set<Integer> discriptBalls = new HashSet<>(balls);
        System.out.println(balls + " : " + discriptBalls);
        assertThat(balls.size()).isNotEqualTo(discriptBalls.size());
    }

    @RepeatedTest(value = 100, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    @DisplayName(value = "중복되지 않은 랜덤한 숫자 3개가 나오는지 체크!")
    public void 중복되지않은3자리수() {
        Set<Integer> balls = new HashSet<>();
        while(balls.size() < 3) {
            balls.add(Randoms.pickNumberInRange(1, 9));
        }
        System.out.println(balls);
        assertThat(balls.size()).isEqualTo(3);
    }
}