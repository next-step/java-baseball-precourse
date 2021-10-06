package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberTest {

    @Test
    void 입력받은_숫자를_문자열로_반환한다() {
        //given
        Number number = new Number(1, 2, 3);

        //when
        String result = number.getValue();

        //then
        assertThat(result).isEqualTo("123");
    }
}