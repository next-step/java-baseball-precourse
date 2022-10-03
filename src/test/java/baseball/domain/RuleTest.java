package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RuleTest {

    Rule rule = new Rule();

    @Test
    void 볼_카운트_테스트(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertThat(rule.matchingBall(4, list)).isFalse();
        assertThat(rule.matchingBall(1,list)).isTrue();

    }

    @Test
    void 스트라이크_카운트_테스트(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertThat(rule.matchingStrike(2, 1, list)).isTrue();
        assertThat(rule.matchingStrike(1, 1, list)).isFalse();
    }

    @Test
    void 결과_문장_테스트(){

        assertThat(rule.getResult(2, "테스트")).isEqualTo("2테스트");
        assertThat(rule.getResult(0, "테스트")).isEqualTo("");
    }

    @ParameterizedTest
    @ValueSource(ints = {1,5})
    void 볼_복합_테스트(int value){
        List<Integer> list = new ArrayList<>();
        list.add(1); list.add(2); list.add(5);

        rule.matchingScore(value,1,list);
        assertThat(rule.getStrike()).isEqualTo(0);
        assertThat(rule.getBall()).isEqualTo(1);
    }

    @Test
    void 볼_스트라이크_복합_테스트(){
        List<Integer> source = new ArrayList<>();
        source.add(1); source.add(2); source.add(5);

        List<Integer> target = new ArrayList<>();
        target.add(2); target.add(1); target.add(5);

        rule.checkStrikeCount(source, target);

        assertThat(rule.getStrike()).isEqualTo(1);
        assertThat(rule.getBall()).isEqualTo(2);
    }
}