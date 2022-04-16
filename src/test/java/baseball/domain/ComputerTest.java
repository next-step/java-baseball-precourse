package baseball.domain;

import baseball.strategy.RandomNumberStrategy;
import baseball.strategy.RandomUniqueNumberStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ComputerTest {

    RandomNumberStrategy strategy;

    @BeforeEach
    void init() {
        strategy = RandomUniqueNumberStrategy.getInstance();
    }
    
    @DisplayName("일의자리 랜덤수 생성")
    @Test
    void 일의자리_랜덤수_생성() throws Exception {
        // given
        Computer computer = Computer.builder().strategy(strategy).build();
        List<Integer> unitNumberList = Arrays.asList(1,2,3,4,5,6,7,8,9);
        // when
        List<Integer> randomNumberList = computer.getChoiceNumbers();

        // then
        Assertions.assertThat(unitNumberList.containsAll(randomNumberList)).isTrue();
    }
    
    @DisplayName("유니크 랜덤수 생성")
    @RepeatedTest(10)
    public void 유니크_랜덤수_생성() throws Exception {
        // given
        Computer computer = Computer.builder().strategy(strategy).build();
        computer.changeNumberCount(9);
        List<Integer> unitNumberList = Arrays.asList(1,2,3,4,5,6,7,8,9);
        // when
        List<Integer> randomNumberList = computer.getChoiceNumbers();
        // then
        Assertions.assertThat(randomNumberList.containsAll(unitNumberList)).isTrue();
    }
}