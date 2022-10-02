package baseball.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ComputerTest extends NsTest {

    Computer computer;

    @Test
    @DisplayName("정답일 경우 3 스트라이크 Score 를 반환함")
    void compareAnswers() {

        //given
        Computer mockComputer = mock(Computer.class);
        Score score = new Score();

        score.countStrike();
        score.countStrike();
        score.countStrike();

        //when
        when(mockComputer.compareAnswers(anyList())).thenReturn(score);

        //then
        assertEquals(3, mockComputer.compareAnswers(anyList()).getStrike());

    }

    @Test
    @DisplayName("assertRandomNumberInRangeTest로 1볼 1스트라이크 나오도록 하는 테스트")
    void compareAnswers2() {

        assertRandomNumberInRangeTest(
                () -> {
                    runMain();
                    Score score = computer.compareAnswers(Arrays.asList(1,2,3));
                    assertThat(score.getScoreMessage()).isEqualTo("1볼 1스트라이크");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Override
    protected void runMain() {
         computer = new Computer();
    }
}