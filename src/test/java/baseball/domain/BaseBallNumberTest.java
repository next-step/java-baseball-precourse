package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BaseBallNumberTest {
    @Test
    void 세자리의_다른숫자로_자동생성하는_기능() {
        BaseBallNumber baseBallNumber = BaseBallNumber.generate();
        assertThat(baseBallNumber.toHashSet().size() == 3);
    }

    @Test
    void 규칙에_일치하는_문자열_입력시_잘_생성되는지() {
        BaseBallNumber baseBallNumber = new BaseBallNumber("123");
        assertThat(baseBallNumber.toHashSet().size() == 3);
        assertThat(baseBallNumber.toString()).contains("1", "2", "3");
    }

    @Test
    void 자릿수_맞지않는_문자열_입력시_에러발생_하는지() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BaseBallNumber("1234"))
                .withMessageContaining("[ERROR]", "자리의");
    }

    @Test
    void 중복된_숫자를_가진_문자열_입력시_에러발생_하는지지() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BaseBallNumber("112"))
                .withMessageContaining("[ERROR]", "중복");
    }

    @Test
    void 숫자가_아닌_문자를_포함한_문자열_입력시_에러발생_하는지() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BaseBallNumber("1a2"))
                .withMessageContaining("[ERROR]", "숫자만");
    }
}