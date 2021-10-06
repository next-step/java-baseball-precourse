package baseball;

import baseball.domain.Validator;
import baseball.exceptions.DuplicateNumberException;
import baseball.exceptions.InvalidInputLengthException;
import baseball.exceptions.NoNumericException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    @Test
    void 입력문자열의_길이가_3개가_아닐때_Exception_발생(){
        String input = "2393";
        assertThrows(InvalidInputLengthException.class, ()-> Validator.validateEnterNumber(input));
    }

    @Test
    void 입력_숫자가_중복일경우_Exception_발생(){
        String input = "233";
        assertThrows(DuplicateNumberException.class, ()-> Validator.validateEnterNumber(input));
    }

    @Test
    void 입력값이_숫자가_아닐일경우_Exception_발생(){
        String input = "변지수";
        assertThrows(NoNumericException.class, ()-> Validator.validateEnterNumber(input));
    }
}