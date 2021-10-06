package baseball.domain;

import baseball.util.NumberGenerator;
import baseball.veiw.ConsoleResponse;
import baseball.enums.GameMessage;
import baseball.veiw.PlayerResponse;

import java.util.HashSet;
import java.util.List;


public class Player {

    public static final int BALLSIZE = 3;

    public static PlayerResponse createPlayerBall() {
        return stringValidationCheck(ConsoleResponse.responseMessage(GameMessage.PLAYER_INPUT_MESSAGE));
    }

    private static PlayerResponse stringValidationCheck(String response){
        try{
            return sizeValidationCheck(response);
        }catch (Exception e) {
            return new PlayerResponse(GameMessage.ERROR_INT);
        }
    }

    private static PlayerResponse sizeValidationCheck(String response) {
        if(response.length() == BALLSIZE) {
            return ballDuplicationCheck(response);
        }
        return new PlayerResponse(GameMessage.ERROR_SIZE);
    }


    private static PlayerResponse ballDuplicationCheck(String response) {
        if(duplicationCheck(NumberGenerator.intToList(Integer.parseInt(response)))) {
            return new PlayerResponse(Integer.parseInt(response), GameMessage.SUCCESS_RESPONSE);
        }
        return new PlayerResponse(GameMessage.ERROR_DUPLICATION);
    }

    private static boolean duplicationCheck(List<Integer> numbers) {
        return new HashSet<>(numbers).size() == numbers.size();
    }

}
