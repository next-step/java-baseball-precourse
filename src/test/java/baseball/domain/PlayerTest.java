package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void 문자가_입력되면_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> new Player("문자")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_숫자가_4자리_이상이면_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> new Player("1234")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_숫자는_3자리_이하여야_한다() {
        Assertions.assertThatThrownBy(() -> new Player("10")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_숫자는_중복_되면_안된다() {
        Assertions.assertThatThrownBy(() -> new Player("131")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_숫자는_0이_포함되면_안된다() {
        Assertions.assertThatThrownBy(() -> new Player("101")).isInstanceOf(IllegalArgumentException.class);
    }
}