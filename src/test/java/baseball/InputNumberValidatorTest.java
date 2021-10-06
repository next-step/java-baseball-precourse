package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputNumberValidatorTest {

    private InputNumberValidator inputNumberValidator;

    @BeforeEach
    void setUp() {
        inputNumberValidator = new InputNumberValidator();
    }

    @Test
    public void 널_여부_체크() {
        assertEquals(inputNumberValidator.validate(null), false);
        assertEquals(inputNumberValidator.validate("123"), true);
    }

    @Test
    public void 길이_3자리_체크() {
        assertEquals(inputNumberValidator.validate("1234"), false);
        assertEquals(inputNumberValidator.validate("12"), false);
        assertEquals(inputNumberValidator.validate("123"), true);
    }

    @Test
    public void 문자열_1에서9인지_체크() {
        assertEquals(inputNumberValidator.validate("a13"), false);
        assertEquals(inputNumberValidator.validate("ㅁㄴㅇ"), false);
        assertEquals(inputNumberValidator.validate("34ㄱ"), false);
        assertEquals(inputNumberValidator.validate("!@#"), false);
        assertEquals(inputNumberValidator.validate("123"), true);
    }

    @Test
    public void 모두_다른_숫자인지_체크() {
        assertEquals(inputNumberValidator.validate("121"), false);
        assertEquals(inputNumberValidator.validate("122"), false);
        assertEquals(inputNumberValidator.validate("331"), false);
        assertEquals(inputNumberValidator.validate("444"), false);
        assertEquals(inputNumberValidator.validate("778"), false);
        assertEquals(inputNumberValidator.validate("123"), true);
        assertEquals(inputNumberValidator.validate("456"), true);
        assertEquals(inputNumberValidator.validate("321"), true);
    }
}
