package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InputNumberValidatorTest {

    private InputNumberValidator inputNumberValidator;

    @BeforeEach
    void setUp() {
        inputNumberValidator = new InputNumberValidator();
    }

    @Test
    public void 널_여부_체크() {
        assertFalse(inputNumberValidator.validate(null));
        assertTrue(inputNumberValidator.validate("123"));
    }

    @Test
    public void 길이_3자리_체크() {
        assertFalse(inputNumberValidator.validate("1234"));
        assertFalse(inputNumberValidator.validate("12"));
        assertTrue(inputNumberValidator.validate("123"));
    }

    @Test
    public void 문자열_1에서9인지_체크() {
        assertFalse(inputNumberValidator.validate("a13"));
        assertFalse(inputNumberValidator.validate("ㅁㄴㅇ"));
        assertFalse(inputNumberValidator.validate("34ㄱ"));
        assertFalse(inputNumberValidator.validate("!@#"));
        assertTrue(inputNumberValidator.validate("123"));
    }

    @Test
    public void 모두_다른_숫자인지_체크() {
        assertFalse(inputNumberValidator.validate("121"));
        assertFalse(inputNumberValidator.validate("122"));
        assertFalse(inputNumberValidator.validate("331"));
        assertFalse(inputNumberValidator.validate("444"));
        assertFalse(inputNumberValidator.validate("778"));
        assertTrue(inputNumberValidator.validate("123"));
        assertTrue(inputNumberValidator.validate("456"));
        assertTrue(inputNumberValidator.validate("321"));
    }
}
