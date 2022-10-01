package baseball.domain;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

class BallGeneratorTest {

    @Test
    void 크기가_3인_번호생성() {
        BallGenerator baseBallCreate = new BallGenerator();
        List<Integer> numberList = baseBallCreate.getNumberList();

        Assertions.assertThat(numberList.size()).isEqualTo(3);
    }

    @Test
    void 중복_없는_랜덤수() {
        BallGenerator baseBallCreate = new BallGenerator();
        List<Integer> numberList = baseBallCreate.getNumberList();

        Set<Integer> setNumbers = Sets.newHashSet(numberList);

        Assertions.assertThat(numberList.size()).isEqualTo(setNumbers.size());
    }
}