package baseball.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import baseball.vo.RuleVo;
import baseball.vo.enumtype.ValidationMsg;
import camp.nextstep.edu.missionutils.test.NsTest;

public class ValidatorServiceTest extends NsTest {
    // start: Singleton Holder
    private ValidatorServiceTest() {
    }


    private static class InnerValidatorService {
        private static final ValidatorServiceTest instance = new ValidatorServiceTest();
    }

    public static ValidatorServiceTest getInstance() {
        return InnerValidatorService.instance;
    }
    // end: Singleton Holder

    // 입력값 검증
    public ValidationMsg validationUserInput(String userInput) {
        if (userInput == null) return ValidationMsg.NULL_TYPE;
        if (userInput.isEmpty()) return ValidationMsg.EMPTY_TYPE;
        try { Integer.valueOf(userInput); } catch (NumberFormatException e) { return ValidationMsg.NOT_NUMBER; }
        if (userInput.equals("0")) return ValidationMsg.ZERO_TYPE;
        if (userInput.length() < RuleVo.getGameNumbersLen()) return ValidationMsg.UNDER_THREE;
        if (userInput.length() > RuleVo.getGameNumbersLen()) return ValidationMsg.OVER_THREE;
        if (isDuplicateUserInput(userInput)) return ValidationMsg.NOT_DUPLICATE_NUMBER;
        return ValidationMsg.PROPER_TYPE;
    }

    // 중복 입력된 숫자값이 있는지 체크
    public boolean isDuplicateUserInput(String userInput) {
        String[] arrUserInput = userInput.split("");
        Set<String> userInputSet = new HashSet<>();
        for (String userInputNum : arrUserInput) {
            userInputSet.add(userInputNum);
        }
        return (arrUserInput.length != userInputSet.size());
    }

    //    ValidationMsg.NULL_TYPE
    @Test
    void string_null_입력_체크() {
        assertEquals(ValidationMsg.NULL_TYPE, validationUserInput(null));
    }

    //    ValidationMsg.EMPTY_TYPE
    @Test
    void string_empty_입력_체크() {
        assertEquals(ValidationMsg.EMPTY_TYPE, validationUserInput(""));
    }

    //    ValidationMsg.NOT_NUMBER
    @Test
    void string_not_number_입력_체크() {
        assertEquals(ValidationMsg.NOT_NUMBER, validationUserInput("1a"));
    }

    //    ValidationMsg.ZERO_TYPE
    @Test
    void string_zero_입력_체크() {
        assertEquals(ValidationMsg.ZERO_TYPE, validationUserInput("0"));
    }

    //    ValidationMsg.UNDER_THREE
    @Test
    void string_3자리_미만_입력_체크() {
        assertEquals(ValidationMsg.UNDER_THREE, validationUserInput("12"));
    }

    //    ValidationMsg.OVER_THREE
    @Test
    void string_3자리_초과_입력_체크() {
        assertEquals(ValidationMsg.OVER_THREE, validationUserInput("1234"));
    }

    @Test
    void String_split_테스트() {
        String userInput = "123";
        String[] arrUserInput = userInput.split("");
        for (String userInputNum : arrUserInput) {
            System.out.println(userInputNum);
        }
    }

    //    ValidationMsg.NOT_DUPLICATE_NUMBER
    @Test
    void string_중복_입력된_숫자값이_있는지_체크() {
        assertEquals(ValidationMsg.NOT_DUPLICATE_NUMBER, validationUserInput("133"));
    }

    @Override
    protected void runMain() {

    }
}
