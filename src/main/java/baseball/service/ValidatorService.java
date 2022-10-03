package baseball.service;

import java.util.HashSet;
import java.util.Set;

import baseball.vo.RuleVo;
import baseball.vo.enumtype.ValidationMsg;

public class ValidatorService {
    // start: Singleton Holder
    private ValidatorService() {
    }

    private static class InnerValidatorService {
        private static final ValidatorService instance = new ValidatorService();
    }

    public static ValidatorService getInstance() {
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
}
