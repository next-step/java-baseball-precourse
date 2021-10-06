package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    @Test
    void 스트라이크가_3인경우_is_correct_메소드는_참을_반환한다() {
        //given
        Result result = new Result(3, 0);

        //when
        boolean isCorrect = result.isCorrect();

        //then
        assertThat(isCorrect).isTrue();
    }

    @Test
    void 정답_메세지를_반환한다() {
        //given
        Result result = new Result(3, 0);

        //when
        String message = result.getMessage();

        //then
        assertThat(message).isEqualTo("3스트라이크 \n3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    @Test
    void 낫싱_메세지를_반환한다() {
        //given
        Result result = new Result(0, 0);

        //when
        String message = result.getMessage();

        //then
        assertThat(message).isEqualTo("낫싱");
    }

    @Test
    void 스코어_메세지를_반환한다() {
        //given
        Result result = new Result(2, 1);

        //when
        String message = result.getMessage();

        //then
        assertThat(message).isEqualTo("2스트라이크 1볼");
    }
}