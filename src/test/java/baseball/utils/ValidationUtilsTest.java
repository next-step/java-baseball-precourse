package baseball.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ValidationUtilsTest {

    @Test
    public void 중복여부확인() {
        assertThat(ValidationUtils.isDuplicate("122")).isEqualTo(true);
    }
}