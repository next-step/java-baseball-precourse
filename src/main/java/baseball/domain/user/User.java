package baseball.domain.user;

import baseball.domain.exceptions.DuplicatedInputNumberException;
import baseball.domain.exceptions.InvalidInputNumberException;
import baseball.domain.utils.Messages;
import baseball.domain.utils.Numbers;
import nextstep.utils.Console;

public class User {

    private final Numbers numbers;

    public User() {
        this.numbers = new Numbers();
    }

    //사용자 입력값 3자리 배열로 변환
    public Integer[] inputTo3differentNumbersArray(String input) throws DuplicatedInputNumberException, InvalidInputNumberException {

        return numbers.getInputNumbersToArray(input);
    }

    //값 입력
    public String readUserInput(Messages text) {
        System.out.println(text.getMessage());
        return Console.readLine();
    }


}
