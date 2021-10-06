package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidationTest {
    @Test
    void 숫자_여부_체크() {
        //given
        //when
        final boolean actual = Validation.validateNumberFormat("1");

        //then
        assertEquals(true, actual);
    }
}
