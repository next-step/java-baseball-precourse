package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValueVerifyTest {
    ValueVerify valueVerify = new ValueVerify(3, 1, 9);

    @Test
    void 입력가능범위_검증_테스트() {
        assertThatThrownBy(() -> valueVerify.verify("12", new LinkedHashSet<>(Arrays.asList(1, 2, 3))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리 숫자가 아닙니다. 1부터 9까지의 서로 다른 3자리 숫자만 입력 가능 합니다.");
    }

    @Test
    void 입력값유형_검증_테스트() {
        assertThatThrownBy(() -> valueVerify.verify("1A3", new LinkedHashSet<>(Arrays.asList(1, 2, 3))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닌 값이 존재합니다. 1부터 9까지의 서로 다른 3자리 숫자만 입력 가능 합니다.");
    }

    @Test
    void 중복값_검증_테스트() {
        assertThatThrownBy(() -> valueVerify.verify("123", new LinkedHashSet<>(Arrays.asList(1, 3, 3))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("동일한 값이 존재합니다. 1부터 9까지의 서로 다른 3자리 숫자만 입력 가능 합니다.");
    }
}
