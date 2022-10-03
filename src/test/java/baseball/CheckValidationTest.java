package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckValidationTest {

    @Test
    void 자리수_검증(){
        boolean result = CheckValidation.sizeCheck("123",3);
        assertThat(result).isTrue();
    }

    @Test
    void 자리수_검증_2(){
        boolean result = CheckValidation.sizeCheck("1234",3);
        assertThat(result).isFalse();
    }

    @Test
    void 숫자검증(){
        boolean result = CheckValidation.isNumeric("1bc");
        assertThat(result).isFalse();
    }

    @Test
    void 숫자검증_2(){
        boolean result = CheckValidation.isNumeric("123");
        assertThat(result).isTrue();
    }

    @Test
    void 숫자범위체크(){
        boolean result = CheckValidation.numberRangeCheck("012");
        assertThat(result).isFalse();
    }
}
