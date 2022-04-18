package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class PlayerInput {

    static final String messageForRequireNumber = "숫자를 입력해주세요 :";
    static final String messageForIllegalNumber = "잘못된 숫자를 입력하였습니다.";



    public List<Integer> getPlayerNumber() throws IllegalArgumentException {
        List<Integer> playerNumbers = new ArrayList<>();
        String stringPlayerNumbers = readPlayerInput();

        for(String stringNumber : stringPlayerNumbers.split("")) {
            playerNumbers.add(parseStringToNumber(stringNumber));
        }

        boolean isValid = validatePlayerNumbers(playerNumbers);
        if(isValid) return playerNumbers;

        throw new IllegalArgumentException(messageForIllegalNumber);

    }

    private String readPlayerInput() {
        System.out.println(this.messageForRequireNumber);
        return Console.readLine();
    }

    private boolean validatePlayerNumbers(List<Integer> playerNumbers) {
        return playerNumbers.size() == 3;
    }

    private Integer parseStringToNumber(String stringNumber) throws IllegalArgumentException{
        try {
            return Integer.parseInt(stringNumber);
        } catch(NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(messageForIllegalNumber);
        }
    }


}
