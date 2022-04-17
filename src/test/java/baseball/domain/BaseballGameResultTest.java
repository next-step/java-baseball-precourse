package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameResultTest {

    @Test
    public void 결과값_스트라이크_볼_증가() throws Exception {
        // given
        BaseballGameResult result = new BaseballGameResult();
        // when
        result.incrementStrike();
        result.incrementBall();
        // then
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    public void 결과값_문자열_출력_볼_스트라이크() throws Exception {
        // given
        BaseballGameResult result = new BaseballGameResult();
        // when
        result.incrementBall();
        result.incrementStrike();
        // then
        assertThat(result.toString()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    public void 결과값_문자열_출력_낫싱() throws Exception {
        // given
        BaseballGameResult result = new BaseballGameResult();
        // when
        // then
        assertThat(result.toString()).isEqualTo("낫싱");
    }

}