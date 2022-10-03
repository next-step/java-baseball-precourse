package baseball.domain;

import baseball.enums.BaseballOption;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Integer> numbers = new ArrayList<>();

    public void setInputNumbers(String inputString) {
        numbers.clear();
        inputStringValidation(inputString);

        for (String input : inputString.split("")) {
            int result = Integer.parseInt(input);
            numbers.add(result);
        }
    }

    public List<Integer> getInputNumbers() {
        return numbers;
    }

    private void inputStringValidation(String inputString) {
        try{
            Integer.parseInt(inputString);
        }catch (NumberFormatException ne){
            throw new IllegalArgumentException("숫자를 입력해주시기 바랍니다.");
        }

        if (inputString.length() > BaseballOption.NUMBERS_LENGTH.getNumber()) {
            throw new IllegalArgumentException(BaseballOption.NUMBERS_LENGTH.getNumber()+"자리 까지 입력가능합니다.");
        }
    }


}
