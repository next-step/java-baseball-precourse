package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JudgementTest {

    private static LinkedList<Integer> ANSWER;
    private static LinkedList<Integer> INPUT;

    private Judgement judgement;

    @BeforeEach
    void setUp() {
        judgement = new Judgement();
        ANSWER = new LinkedList<>();
        ANSWER.addAll(Arrays.asList(1, 2, 3));
        INPUT = new LinkedList<>();
        INPUT.addAll(Arrays.asList(1, 3, 9));
    }

    @Test
    void 스트라이크_1() {
        int result = judgement.getStrikeCount(0, ANSWER, INPUT, 0);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 스트라이크_0() {
        int result = judgement.getStrikeCount(0, ANSWER, INPUT, 1);
        assertThat(result).isEqualTo(0);
    }

}