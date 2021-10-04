package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BaseballTest {

    Baseball baseball = new Baseball();

    @Test
    void 스트라이크_볼_테스트() {
        //given
        baseball.setComputerNum("789");
        //when
        baseball.setPlayerNum("187");
        //then
        baseball.setStrikeAndBall();
        Assertions.assertThat(baseball.getStrike()).isEqualTo(1);
        Assertions.assertThat(baseball.getBall()).isEqualTo(1);
    }

    @Test
    void 사용자_입력값_테스트() {
        //given
        baseball.setPlayerNum("123");
        //when
        boolean b = baseball.checkPlayerNum();
        //then
        Assertions.assertThat(b).isTrue();
    }

    @Test
    void 사용자_입력값_에러_테스트_영문자() {
        //given
        baseball.setPlayerNum("abc");
        //when
        boolean b = baseball.checkPlayerNum();
        //then
        Assertions.assertThat(b).isFalse();
    }

    @Test
    void 사용자_입력값_에러_테스트_글자수() {
        //given
        baseball.setPlayerNum("1234");
        //when
        boolean b = baseball.checkPlayerNum();
        //then
        Assertions.assertThat(b).isFalse();
    }

    @Test
    void 사용자_입력값_에러_테스트_빈문자열() {
        //given
        baseball.setPlayerNum("");
        //when
        boolean b = baseball.checkPlayerNum();
        //then
        Assertions.assertThat(b).isFalse();
    }
}