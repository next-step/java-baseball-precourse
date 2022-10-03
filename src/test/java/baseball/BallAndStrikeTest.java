package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallAndStrikeTest {

    @Test
    void 볼_스트라이크_체크_1(){
        List<Integer> answer = new ArrayList<Integer>();
        answer.add(1);
        answer.add(2);
        answer.add(3);
        List<Integer> input = new ArrayList<Integer>();
        input.add(1);
        input.add(2);
        input.add(5);
        Answer result = BallAndStrike.check(answer,input);
        assertThat(result.getStrike()).isEqualTo(2);
    }

    @Test
    void 볼_스트라이크_체크_2(){
        List<Integer> answer = new ArrayList<Integer>();
        answer.add(1);
        answer.add(2);
        answer.add(3);
        List<Integer> input = new ArrayList<Integer>();
        input.add(2);
        input.add(4);
        input.add(3);
        Answer result = BallAndStrike.check(answer,input);
        assertThat(result.getBall()).isEqualTo(1);
        assertThat(result.getStrike()).isEqualTo(1);
    }

    @Test
    void 스코어_변환(){
        Answer answer = new Answer(0,0);
        String result = BallAndStrike.printScore(answer);
        assertThat(result).isEqualTo("낫싱");
    }
    @Test
    void 스코어_변환_2(){
        Answer answer = new Answer(1,1);
        String result = BallAndStrike.printScore(answer);
        assertThat(result).isEqualTo("1볼 1스트라이크");
    }
}
