package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class NumberUtilTest {
    @Test
    @DisplayName("숫자_패턴_검증")
    public void 숫자_패턴_검증(){
        assertTrue(NumberUtil.isNumber("1234"));
        assertFalse(NumberUtil.isNumber("테스트"));
    }

    @Test
    @DisplayName("텍스트_숫자_리스트_변환")
    public void 텍스트_숫자_리스트_변환(){
        assertThat(NumberUtil.splitNumberByString("1234")).isNotEmpty().hasSize(4);
    }

    @Test
    @DisplayName("텍스트_숫자_검증")
    public void 텍스트_숫자_검증(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> NumberUtil.splitNumberByString("텍스트"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
